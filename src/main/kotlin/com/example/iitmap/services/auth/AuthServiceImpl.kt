package com.example.iitmap.services.auth

import com.example.iitmap.models.auth.*
import com.example.iitmap.models.token.Token
import com.example.iitmap.models.token.TokenResponse
import com.example.iitmap.repositories.TokenRepo
import com.example.iitmap.repositories.UserRepo
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class AuthServiceImpl(
    private val userRepo: UserRepo,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder,
    private val tokenRepo: TokenRepo,
    private val authManager: AuthenticationManager
) : AuthService {
    override fun register(credential: RegisterCredential): TokenResponse {
        if (userRepo.existsUserByLogin(credential.login)) {
            throw IllegalArgumentException("User already exist")
        }
        val user: User = credential.toUser()
        user.password = passwordEncoder.encode(user.password)
        user.role = Role.USER
        val savedUser = userRepo.save(user)
        val jwt: String = jwtService.generateToken(UserDetailImpl.of(user))
        saveUserToken(jwt, savedUser)
        return TokenResponse(jwt)
    }

    private fun saveUserToken(jwtToken: String, user: User) {
        val token = Token(id = -1L, token = jwtToken, revoked = false, expired = false, user = user)
        tokenRepo.save(token)
    }

    override fun login(credential: LoginCredential): TokenResponse {
        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                credential.login,
                credential.password
            )
        )
        val user: User = userRepo.findUserByLogin(credential.login)
        val jwt: String = jwtService.generateToken(UserDetailImpl.of(user))
        revokeAllUserTokens(user)
        saveUserToken(jwt, user)
        return TokenResponse(jwt)
    }

    private fun revokeAllUserTokens(user: User) {
        val userTokens: List<Token> = tokenRepo.findAllValidTokenByUserId(user.id)
        if (userTokens.isEmpty()) {
            return
        }
        userTokens.forEach {
            it.revoked = true
            it.expired = true
        }
        tokenRepo.saveAll(userTokens)
    }
}
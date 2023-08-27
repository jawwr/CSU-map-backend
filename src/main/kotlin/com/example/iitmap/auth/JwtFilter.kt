package com.example.iitmap.auth

import com.example.iitmap.models.auth.UserDetailImpl
import com.example.iitmap.models.token.Token
import com.example.iitmap.repositories.TokenRepo
import com.example.iitmap.services.auth.JwtService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
class JwtFilter(
    private val jwtService: JwtService,
    private val userDetailsService: UserDetailsService,
    private val tokenRepository: TokenRepo
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }
        val jwt: String = authHeader.substring(7)
        val userLogin: String = jwtService.extractLogin(jwt)
        if (SecurityContextHolder.getContext().authentication == null) {
            val userDetails: UserDetailImpl = this.userDetailsService.loadUserByUsername(userLogin) as UserDetailImpl
            val userTokens: Token = tokenRepository.findByToken(jwt)
            val isTokenValid = !userTokens.revoked && !userTokens.expired
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                val token = UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.authorities
                )
                token.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = token
            }
        }
        filterChain.doFilter(request, response)
    }
}
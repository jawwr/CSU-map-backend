package com.example.iitmap.services.auth

import com.example.iitmap.models.auth.UserDetailImpl
import com.example.iitmap.repositories.UserRepo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailServiceImpl(
    private val userRepo: UserRepo
) : UserDetailsService {
    override fun loadUserByUsername(login: String): UserDetails {
        val user = userRepo.findUserByLogin(login = login)
        return UserDetailImpl.of(user)
    }
}
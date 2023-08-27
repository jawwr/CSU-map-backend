package com.example.iitmap.services.auth

import com.example.iitmap.models.auth.LoginCredential
import com.example.iitmap.models.auth.RegisterCredential
import com.example.iitmap.models.token.TokenResponse

interface AuthService {
    fun login(credential: LoginCredential): TokenResponse
    fun register(credential: RegisterCredential): TokenResponse
}
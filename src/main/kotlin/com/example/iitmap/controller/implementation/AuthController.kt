package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.AuthApi
import com.example.iitmap.models.auth.LoginCredential
import com.example.iitmap.models.auth.RegisterCredential
import com.example.iitmap.models.token.TokenResponse
import com.example.iitmap.services.auth.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val service: AuthService) : AuthApi {
    override fun register(credential: RegisterCredential): ResponseEntity<TokenResponse> =
        ResponseEntity.ok(service.register(credential))

    override fun login(credential: LoginCredential): ResponseEntity<TokenResponse> =
        ResponseEntity.ok(service.login(credential))
}
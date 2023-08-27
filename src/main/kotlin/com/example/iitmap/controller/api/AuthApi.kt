package com.example.iitmap.controller.api

import com.example.iitmap.models.auth.LoginCredential
import com.example.iitmap.models.auth.RegisterCredential
import com.example.iitmap.models.token.TokenResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/auth")
@Tag(name = "Api авторизации")
interface AuthApi {
    @PostMapping("/register")
    fun register(@RequestBody credential: RegisterCredential): ResponseEntity<TokenResponse>

    @PostMapping("/login")
    fun login(@RequestBody credential: LoginCredential): ResponseEntity<TokenResponse>
}
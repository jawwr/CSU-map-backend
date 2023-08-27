package com.example.iitmap.models.auth

data class RegisterCredential(
    val login: String,
    val password: String
) {
    fun toUser(): User {
        return User(
            id = 0,
            login = login,
            password = password,
            role = Role.USER
        )
    }
}
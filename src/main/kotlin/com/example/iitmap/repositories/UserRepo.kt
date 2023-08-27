package com.example.iitmap.repositories

import com.example.iitmap.models.auth.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User, Long> {
    fun findUserByLogin(login: String): User

    fun existsUserByLogin(login: String): Boolean
}
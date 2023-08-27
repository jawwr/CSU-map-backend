package com.example.iitmap.repositories

import com.example.iitmap.models.token.Token
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TokenRepo : JpaRepository<Token, Long> {
    @Query(
        value = """
            SELECT tokens.*
            FROM tokens
            JOIN users
            ON users.id = tokens.user_id
            WHERE user_id = :#{#userId}
            AND (tokens.expired = false or tokens.revoked = false)
            """, nativeQuery = true
    )
    fun findAllValidTokenByUserId(userId: Long?): List<Token>

    fun findByToken(token: String?): Token
}
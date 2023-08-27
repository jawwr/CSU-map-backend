package com.example.iitmap.services.auth

import com.example.iitmap.models.auth.UserDetailImpl
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.security.Key
import java.util.*


@Service
class JwtService {
    @Value("\${app.jwtSecret}")
    private lateinit var SECRET_KEY: String
    fun extractLogin(token: String): String {
        return extractClaim(token, Claims::getSubject)
    }

    fun generateToken(extractClaims: Map<String, Any>, userDetails: UserDetailImpl): String {
        return Jwts.builder()
            .setClaims(extractClaims)
            .setSubject(userDetails.username)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 8))
            .signWith(getSignInKey(), SignatureAlgorithm.HS256)
            .compact()
    }

    fun generateToken(userDetails: UserDetailImpl): String {
        return generateToken(HashMap(), userDetails)
    }

    fun isTokenValid(token: String, userDetails: UserDetailImpl): Boolean {
        val login = extractLogin(token)
        return login == userDetails.username && !isTokenExpired(token)
    }

    private fun isTokenExpired(token: String): Boolean {
        return extractExpiration(token).before(Date())
    }

    private fun extractExpiration(token: String): Date {
        return extractClaim(token, Claims::getExpiration)
    }

    fun <T> extractClaim(token: String, claimsResolver: (Claims) -> T): T {
        val claims = extractAllClaims(token)
        return claimsResolver(claims)
    }

    private fun extractAllClaims(token: String): Claims {
        return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .body
    }

    private fun getSignInKey(): Key {
        val keyBytes = Decoders.BASE64.decode(SECRET_KEY)
        return Keys.hmacShaKeyFor(keyBytes)
    }
}
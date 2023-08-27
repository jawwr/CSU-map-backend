package com.example.iitmap.models.token

import com.example.iitmap.models.auth.User
import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "tokens")
data class Token(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "token")
    val token: String,

    @Column(name = "revoked")
    var revoked: Boolean,

    @Column(name = "expired")
    var expired: Boolean,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)
package com.example.iitmap.models

import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "floors")
data class Floor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "number", nullable = false)
    var number: Int,

    @Column(name = "tilemap_link", nullable = false)
    val tilemap: String,

    @OneToMany
    val transitions: List<Transition>,

    @OneToMany
    val points: List<Point>
)
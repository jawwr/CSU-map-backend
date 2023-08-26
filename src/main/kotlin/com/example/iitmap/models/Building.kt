package com.example.iitmap.models

import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "buildings")
data class Building(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @Column(name = "name", nullable = false)
    val name: String,

    @OneToMany
    val floor: List<Floor>?
)

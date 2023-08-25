package com.example.iitmap.models

import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "transitions")
data class Transition(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "point_type", nullable = false)
    val transitionType: TransitionType,

    @Column(name = "x_position", nullable = false)
    val x: Double,

    @Column(name = "y_position", nullable = false)
    val y: Double
)

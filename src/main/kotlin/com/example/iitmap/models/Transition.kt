package com.example.iitmap.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "transitions")
data class Transition(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @ManyToOne
    @JsonIgnore
    var floor: Floor,

    @ManyToOne
    @JoinColumn(name = "point_type", nullable = false)
    var transitionType: TransitionType,

    @Column(name = "x_position", nullable = false)
    val x: Double,

    @Column(name = "y_position", nullable = false)
    val y: Double
)

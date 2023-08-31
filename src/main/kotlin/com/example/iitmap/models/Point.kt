package com.example.iitmap.models

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "points")
data class Point(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @ManyToOne
    @JsonIgnore
    var floor: Floor?,

    @ManyToOne
    @JoinColumn(name = "point_type", nullable = false)
    var pointType: PointType,

    @Column(name = "first_field")
    val firstField: String?,

    @Column(name = "second_field")
    val secondField: String?,

    @Column(name = "third_field")
    val thirdField: String?,

    @Column(name = "x_position", nullable = false)
    val x: Double,

    @Column(name = "y_position", nullable = false)
    val y: Double
)

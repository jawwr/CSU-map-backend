package com.example.iitmap.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
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

    @ManyToOne
    @JsonIgnore
    var building: Building?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "floor")
    @JsonIgnore
    @JsonBackReference
    val points: List<Point>?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "floor")
    @JsonIgnore
    @JsonBackReference
    val transitions: List<Transition>?,
)
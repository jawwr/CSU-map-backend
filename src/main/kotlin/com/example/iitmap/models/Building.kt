package com.example.iitmap.models

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
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

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "building")
    @JsonIgnore
    @JsonBackReference
    val floors: List<Floor>?
)

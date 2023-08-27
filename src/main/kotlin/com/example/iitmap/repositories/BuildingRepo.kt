package com.example.iitmap.repositories

import com.example.iitmap.models.Building
import org.springframework.data.jpa.repository.JpaRepository

interface BuildingRepo : JpaRepository<Building, Long> {
    fun findBuildingById(id: Long): Building?
}
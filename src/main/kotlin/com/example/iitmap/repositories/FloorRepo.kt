package com.example.iitmap.repositories

import com.example.iitmap.models.Floor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

interface FloorRepo : JpaRepository<Floor, Long> {
    fun findAllByBuildingId(buildingId: Long): List<Floor>
    fun findFloorByBuildingIdAndNumber(id: Long, number: Int): Floor?

    @Transactional
    fun deleteByBuildingIdAndNumber(buildingId: Long, number: Int)
}
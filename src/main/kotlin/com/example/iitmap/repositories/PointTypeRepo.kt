package com.example.iitmap.repositories

import com.example.iitmap.models.PointType
import org.springframework.data.jpa.repository.JpaRepository

interface PointTypeRepo : JpaRepository<PointType, Long> {
    fun getPointTypeByName(name: String): PointType?
}
package com.example.iitmap.repositories

import com.example.iitmap.models.Point
import org.springframework.data.jpa.repository.JpaRepository

interface PointRepo : JpaRepository<Point, Long> {
    fun findAllPointByFloorId(floorId: Long): List<Point>

    fun findPointById(id: Long): Point?
}
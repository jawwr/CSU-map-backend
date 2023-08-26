package com.example.iitmap.services

import com.example.iitmap.models.Point

interface PointService {
    fun getAllPoints(buildingId: Long, floorNumber: Int): List<Point>
    fun createPoint(buildingId: Long, floorNumber: Int, point: Point): Long
    fun updatePoint(buildingId: Long, floorNumber: Int, point: Point)
    fun deletePoint(buildingId: Long, floorNumber: Int, pointId: Long)
}
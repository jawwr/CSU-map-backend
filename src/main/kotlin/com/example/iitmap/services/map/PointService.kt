package com.example.iitmap.services.map

import com.example.iitmap.models.Point

interface PointService {
    fun getAllPoints(buildingId: Long, floorNumber: Int): List<Point>
    fun getPointById(pointId: Long): Point
    fun createPoint(buildingId: Long, floorNumber: Int, point: Point): Long
    fun updatePoint(buildingId: Long, floorNumber: Int, point: Point)
    fun deletePoint(buildingId: Long, floorNumber: Int, pointId: Long)
}
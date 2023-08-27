package com.example.iitmap.services

import com.example.iitmap.models.Floor

interface FloorService {
    fun getAllFloor(buildingId: Long): List<Floor>
    fun getFloorByNumber(buildingId: Long, floorNumber: Int): Floor
    fun createFloor(buildingId: Long, floor: Floor): Long
    fun updateFloor(buildingId: Long, floor: Floor)
    fun deleteFloor(buildingId: Long, floorNumber: Int)
}
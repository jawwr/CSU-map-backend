package com.example.iitmap.services.map

import com.example.iitmap.models.Building

interface BuildingService {
    fun getBuildingById(id: Long): Building
    fun getAllBuildings(): List<Building>
    fun createBuilding(building: Building): Long
    fun updateBuilding(building: Building)
    fun deleteBuilding(buildingId: Long)
}
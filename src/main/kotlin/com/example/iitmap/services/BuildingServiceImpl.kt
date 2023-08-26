package com.example.iitmap.services

import com.example.iitmap.models.Building
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BuildingServiceImpl : BuildingService {
    override fun getBuildingById(id: Long): Building {
        TODO("Not yet implemented")
    }

    override fun getAllBuildings(): List<Building> {
        TODO("Not yet implemented")
    }

    override fun createBuilding(building: Building): Long {
        TODO("Not yet implemented")
    }

    override fun updateBuilding(building: Building) {
        TODO("Not yet implemented")
    }

    override fun deleteBuilding(buildingId: Long) {
        TODO("Not yet implemented")
    }

    companion object {
        val log = LoggerFactory.getLogger(this::class.java)
    }
}
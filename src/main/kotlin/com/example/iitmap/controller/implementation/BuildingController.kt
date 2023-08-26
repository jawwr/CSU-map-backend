package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.BuildingApi
import com.example.iitmap.models.Building
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class BuildingController : BuildingApi {
    override fun getBuildingById(buildingId: Long): ResponseEntity<Building> {
        TODO("Not yet implemented")
    }

    override fun getAllBuildings(): ResponseEntity<List<Building>> {
        TODO("Not yet implemented")
    }

    override fun createBuilding(building: Building): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    override fun updateBuildingById(buildingId: Long, building: Building): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteBuildingById(buildingId: Long): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }
}
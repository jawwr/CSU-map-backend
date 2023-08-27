package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.BuildingApi
import com.example.iitmap.models.Building
import com.example.iitmap.services.map.BuildingService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class BuildingController(private val service: BuildingService) : BuildingApi {
    override fun getBuildingById(buildingId: Long): ResponseEntity<Building> =
        ResponseEntity.ok(service.getBuildingById(id = buildingId))

    override fun getAllBuildings(): ResponseEntity<List<Building>> = ResponseEntity.ok(service.getAllBuildings())

    override fun createBuilding(building: Building): ResponseEntity<Long> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createBuilding(building = building))
    }

    override fun updateBuildingById(buildingId: Long, building: Building): ResponseEntity<Void> {
        building.id = buildingId
        service.updateBuilding(building = building)
        return ResponseEntity.ok().build()
    }

    override fun deleteBuildingById(buildingId: Long): ResponseEntity<Void> {
        service.deleteBuilding(buildingId = buildingId)
        return ResponseEntity.ok().build()
    }
}
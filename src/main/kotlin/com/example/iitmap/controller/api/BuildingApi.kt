package com.example.iitmap.controller.api

import com.example.iitmap.models.Building
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/building")
interface BuildingApi {
    @GetMapping("/{buildingId}")
    fun getBuildingById(@PathVariable("buildingId") buildingId: Long): ResponseEntity<Building>

    @GetMapping
    fun getAllBuildings(): ResponseEntity<List<Building>>

    @PostMapping
    fun createBuilding(@RequestBody building: Building): ResponseEntity<Void>

    @PutMapping("/{buildingId}")
    fun updateBuildingById(
        @PathVariable("buildingId") buildingId: Long,
        @RequestBody building: Building
    ): ResponseEntity<Void>

    @DeleteMapping("/{buildingId}")
    fun deleteBuildingById(@PathVariable("buildingId") buildingId: Long): ResponseEntity<Void>
}
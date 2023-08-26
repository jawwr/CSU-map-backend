package com.example.iitmap.controller.api

import com.example.iitmap.models.Floor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/building/{buildingId}/floor")
interface FloorApi {
    @GetMapping("/{floorNumber}")
    fun getFloorByNumber(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int
    ): ResponseEntity<Floor>

    @GetMapping
    fun getAllFloorsInBuilding(@PathVariable("buildingId") buildingId: Long): ResponseEntity<List<Floor>>

    @PostMapping
    fun createFloorInBuilding(
        @PathVariable("buildingId") buildingId: Long,
        @RequestBody floor: Floor
    ): ResponseEntity<Void>

    @PutMapping("/{floorNumber}")
    fun updateFloorInBuilding(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @RequestBody floor: Floor
    ): ResponseEntity<Void>

    @DeleteMapping("/{floorNumber}")
    fun deleteFloorInBuilding(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int
    ): ResponseEntity<Void>
}
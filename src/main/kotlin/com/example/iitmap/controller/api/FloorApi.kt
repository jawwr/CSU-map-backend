package com.example.iitmap.controller.api

import com.example.iitmap.models.Floor
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/building/{buildingId}/floor")
@Tag(name = "Api для этажей в корпусе")
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
    ): ResponseEntity<Long>

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
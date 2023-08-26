package com.example.iitmap.controller.api

import com.example.iitmap.models.Point
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/building/{buildingId}/floor/{floorNumber}/point")
interface PointApi {
    @GetMapping
    fun getPointsOnFloor(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int
    ): ResponseEntity<List<Point>>

    @PostMapping
    fun createPointsOnFloor(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @RequestBody point: Point
    ): ResponseEntity<Void>

    @PutMapping("/{pointId}")
    fun updatePoint(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @PathVariable("pointId") pointId: Long,
        @RequestBody point: Point
    ): ResponseEntity<Void>

    @DeleteMapping("/{pointId}")
    fun deletePoint(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @PathVariable("pointId") pointId: Long
    ): ResponseEntity<Void>
}
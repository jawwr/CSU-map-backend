package com.example.iitmap.controller.api

import com.example.iitmap.models.Point
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/building/{buildingId}/floor/{floorNumber}/point")
@Tag(name = "Api для точек на этаже")
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
    ): ResponseEntity<Long>

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
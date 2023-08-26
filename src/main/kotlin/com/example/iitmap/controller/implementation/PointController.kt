package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.PointApi
import com.example.iitmap.models.Point
import com.example.iitmap.services.PointService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PointController(private val service: PointService) : PointApi {
    override fun getPointsOnFloor(buildingId: Long, floorNumber: Int): ResponseEntity<List<Point>> {
        return ResponseEntity.ok(
            service.getAllPoints(
                buildingId = buildingId,
                floorNumber = floorNumber
            )
        )
    }

    override fun createPointsOnFloor(buildingId: Long, floorNumber: Int, point: Point): ResponseEntity<Long> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            service.createPoint(
                buildingId = buildingId,
                floorNumber = floorNumber,
                point = point
            )
        )
    }

    override fun updatePoint(buildingId: Long, floorNumber: Int, pointId: Long, point: Point): ResponseEntity<Void> {
        point.id = pointId
        service.updatePoint(
            buildingId = buildingId,
            floorNumber = floorNumber,
            point = point
        )
        return ResponseEntity.ok().build()
    }

    override fun deletePoint(buildingId: Long, floorNumber: Int, pointId: Long): ResponseEntity<Void> {
        service.deletePoint(
            buildingId = buildingId,
            floorNumber = floorNumber,
            pointId = pointId
        )
        return ResponseEntity.ok().build()
    }
}
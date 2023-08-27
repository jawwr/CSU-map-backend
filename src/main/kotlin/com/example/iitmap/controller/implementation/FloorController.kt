package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.FloorApi
import com.example.iitmap.models.Floor
import com.example.iitmap.services.map.FloorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class FloorController(private val service: FloorService) : FloorApi {
    override fun getFloorByNumber(buildingId: Long, floorNumber: Int): ResponseEntity<Floor> =
        ResponseEntity.ok(
            service.getFloorByNumber(
                buildingId = buildingId,
                floorNumber = floorNumber
            )
        )

    override fun getAllFloorsInBuilding(buildingId: Long): ResponseEntity<List<Floor>> =
        ResponseEntity.ok(service.getAllFloor(buildingId = buildingId))


    override fun createFloorInBuilding(buildingId: Long, floor: Floor): ResponseEntity<Long> =
        ResponseEntity.status(HttpStatus.CREATED).body(
            service.createFloor(
                buildingId = buildingId,
                floor = floor
            )
        )


    override fun updateFloorInBuilding(buildingId: Long, floorNumber: Int, floor: Floor): ResponseEntity<Void> {
        floor.number = floorNumber
        service.updateFloor(
            buildingId = buildingId,
            floor = floor
        )
        return ResponseEntity.ok().build()
    }

    override fun deleteFloorInBuilding(buildingId: Long, floorNumber: Int): ResponseEntity<Void> {
        service.deleteFloor(
            buildingId = buildingId,
            floorNumber = floorNumber
        )
        return ResponseEntity.ok().build()
    }
}
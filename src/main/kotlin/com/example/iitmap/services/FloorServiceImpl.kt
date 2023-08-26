package com.example.iitmap.services

import com.example.iitmap.models.Floor
import org.springframework.stereotype.Service

@Service
class FloorServiceImpl : FloorService {
    override fun getAllFloor(buildingId: Long): List<Floor> {
        TODO("Not yet implemented")
    }

    override fun getFloorById(buildingId: Long, floorNumber: Int): Floor {
        TODO("Not yet implemented")
    }

    override fun createFloor(buildingId: Long, floor: Floor): Long {
        TODO("Not yet implemented")
    }

    override fun updateFloor(buildingId: Long, floorNumber: Int, floor: Floor) {
        TODO("Not yet implemented")
    }

    override fun deleteFloor(buildingId: Long, floorNumber: Int) {
        TODO("Not yet implemented")
    }
}
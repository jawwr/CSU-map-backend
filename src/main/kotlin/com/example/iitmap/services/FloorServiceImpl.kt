package com.example.iitmap.services

import com.example.iitmap.exceptions.FloorAlreadyExistException
import com.example.iitmap.exceptions.FloorNotExistException
import com.example.iitmap.models.Floor
import com.example.iitmap.repositories.FloorRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FloorServiceImpl(
    private val repo: FloorRepo,
    private val buildingService: BuildingService
) : FloorService {
    override fun getAllFloor(buildingId: Long): List<Floor> {
        buildingService.getBuildingById(buildingId)
        return repo.findAllByBuildingId(buildingId)
    }

    override fun getFloorByNumber(buildingId: Long, floorNumber: Int): Floor {
        buildingService.getBuildingById(buildingId)
        return repo.findFloorByBuildingIdAndNumber(buildingId, floorNumber)
            ?: throw FloorNotExistException("Floor with number $floorNumber not exist")
    }

    @Transactional
    override fun createFloor(buildingId: Long, floor: Floor): Long {
        if (floor.id != 0L) {
            throw IllegalArgumentException("Floor id must be 0")
        }
        val isAlreadyExist: Boolean = try {
            getFloorByNumber(buildingId, floor.number)
            true
        } catch (e: FloorNotExistException) {
            false
        }
        if (isAlreadyExist) {
            throw FloorAlreadyExistException("Floor ${floor.number} in building $buildingId already exists")
        }
        val building = buildingService.getBuildingById(buildingId)
        floor.building = building
        return repo.save(floor).id
    }

    @Transactional
    override fun updateFloor(buildingId: Long, floor: Floor) {
        val savedFloor = getFloorByNumber(buildingId, floor.number)
        floor.building = savedFloor.building
        repo.save(floor)
    }

    @Transactional
    override fun deleteFloor(buildingId: Long, floorNumber: Int) {
        getFloorByNumber(buildingId, floorNumber)
        repo.deleteByBuildingIdAndNumber(buildingId, floorNumber)
    }
}
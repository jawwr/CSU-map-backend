package com.example.iitmap.services

import com.example.iitmap.exceptions.BuildingNotExistException
import com.example.iitmap.models.Building
import com.example.iitmap.repositories.BuildingRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BuildingServiceImpl(private val repo: BuildingRepo) : BuildingService {
    override fun getBuildingById(id: Long): Building {
        return repo.findBuildingById(id) ?: throw BuildingNotExistException("Building with id $id doesn't exists")
    }

    override fun getAllBuildings(): List<Building> {
        return repo.findAll()
    }

    override fun createBuilding(building: Building): Long {
        if (building.id != 0L) {
            throw IllegalArgumentException("Building id must be 0")
        }
        return repo.save(building).id
    }

    @Transactional
    override fun updateBuilding(building: Building) {
        getBuildingById(building.id)
        repo.save(building)
    }

    override fun deleteBuilding(buildingId: Long) {
        repo.deleteById(buildingId)
    }
}
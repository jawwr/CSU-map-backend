package com.example.iitmap.services

import com.example.iitmap.exceptions.PointTypeNotExistException
import com.example.iitmap.models.Point
import com.example.iitmap.repositories.PointRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PointServiceImpl(
    private val repo: PointRepo,
    private val floorService: FloorService,
    private val pointConfigService: PointConfigService
) : PointService {
    override fun getAllPoints(buildingId: Long, floorNumber: Int): List<Point> {
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        return repo.findAllPointByFloorId(floor.id)
    }

    override fun getPointById(pointId: Long): Point {
        return repo.findPointById(pointId) ?: throw PointTypeNotExistException("Point with id $pointId doesn't exist")
    }

    @Transactional
    override fun createPoint(buildingId: Long, floorNumber: Int, point: Point): Long {
        if (point.id != 0L) {
            throw IllegalArgumentException("Point id must be 0")
        }
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        val type = pointConfigService.getTypeByName(point.pointType.name)
        point.floor = floor
        point.pointType = type
        return repo.save(point).id
    }

    @Transactional
    override fun updatePoint(buildingId: Long, floorNumber: Int, point: Point) {
        val saved = getPointById(point.id)
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        if (saved.floor!!.id != floor.id) {
            throw PointTypeNotExistException("Point doesn't apply to floor $floorNumber")
        }
        val type = pointConfigService.getTypeByName(point.pointType.name)
        point.floor = floor
        point.pointType = type
        repo.save(point)
    }

    @Transactional
    override fun deletePoint(buildingId: Long, floorNumber: Int, pointId: Long) {
        val saved = getPointById(pointId)
        if (saved.floor!!.building!!.id != buildingId) {
            throw PointTypeNotExistException("Point doesn't apply to building $buildingId")
        }
        if (saved.floor!!.number != floorNumber) {
            throw PointTypeNotExistException("Point doesn't apply to floor $floorNumber")
        }
        repo.deleteById(saved.id)
    }
}
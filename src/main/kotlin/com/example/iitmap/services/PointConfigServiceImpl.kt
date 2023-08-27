package com.example.iitmap.services

import com.example.iitmap.exceptions.PointTypeAlreadyExistException
import com.example.iitmap.exceptions.PointTypeNotExistException
import com.example.iitmap.models.PointType
import com.example.iitmap.repositories.PointTypeRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PointConfigServiceImpl(private val repo: PointTypeRepo) : PointConfigService {
    override fun getAllTypes(): List<PointType> {
        return repo.findAll()
    }

    @Transactional
    override fun createType(type: PointType): Long {
        if (type.id != 0L) {
            throw IllegalArgumentException("Point type id must be 0")
        }
        val isAlreadyExist: Boolean = try {
            getTypeByName(type.name)
            true
        } catch (e: PointTypeNotExistException) {
            false
        }
        if (isAlreadyExist) {
            throw PointTypeAlreadyExistException("Point type with name '${type.name}' already exist")
        }
        return repo.save(type).id
    }

    @Transactional
    override fun updateType(type: PointType) {
        val isAlreadyExist: Boolean = try {
            getTypeByName(type.name)
            true
        } catch (e: PointTypeNotExistException) {
            false
        }
        if (isAlreadyExist) {
            throw PointTypeAlreadyExistException("Point type with name '${type.name}' already exist")
        }
        repo.save(type)
    }

    override fun deleteType(typeId: Long) {
        repo.deleteById(typeId)
    }

    override fun getTypeByName(name: String): PointType {
        return repo.getPointTypeByName(name)
            ?: throw PointTypeNotExistException("Point type with name '$name' doesn't exist")
    }
}
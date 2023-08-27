package com.example.iitmap.services

import com.example.iitmap.exceptions.TransitionTypeAlreadyExistException
import com.example.iitmap.exceptions.TransitionTypeNotExistException
import com.example.iitmap.models.TransitionType
import com.example.iitmap.repositories.TransitionTypeRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransitionConfigServiceImpl(private val repo: TransitionTypeRepo) : TransitionConfigService {
    override fun getAllTransitionTypes(): List<TransitionType> {
        return repo.findAll()
    }

    @Transactional
    override fun createTransitionType(type: TransitionType): Long {
        if (type.id != 0L) {
            throw IllegalArgumentException("Transition type id must be 0")
        }
        val isAlreadyExist: Boolean = try {
            getTransitionTypeByName(type.name)
            true
        } catch (e: TransitionTypeNotExistException) {
            false
        }
        if (isAlreadyExist) {
            throw TransitionTypeAlreadyExistException("Transition type with name '${type.name}' already exist")
        }
        return repo.save(type).id
    }

    @Transactional
    override fun updateTransitionType(type: TransitionType) {
        val isAlreadyExist: Boolean = try {
            getTransitionTypeByName(type.name)
            true
        } catch (e: TransitionTypeNotExistException) {
            false
        }
        if (isAlreadyExist) {
            throw TransitionTypeAlreadyExistException("Transition type with name '${type.name}' already exist")
        }
        repo.save(type)
    }

    override fun deleteTransitionType(typeId: Long) {
        getTransactionTypeById(typeId)
        repo.deleteById(typeId)
    }

    override fun getTransitionTypeByName(name: String): TransitionType {
        return repo.findTransitionTypeByName(name)
            ?: throw TransitionTypeNotExistException("Transition type with name '$name' doesn't exists")
    }

    override fun getTransactionTypeById(id: Long): TransitionType {
        return repo.findTransitionTypeById(id)
            ?: throw TransitionTypeNotExistException("Transition type with id $id doesn't exists")
    }
}
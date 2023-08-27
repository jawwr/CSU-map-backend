package com.example.iitmap.services

import com.example.iitmap.exceptions.TransitionNotExistException
import com.example.iitmap.models.Transition
import com.example.iitmap.repositories.TransitionRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransitionServiceImpl(
    private val repo: TransitionRepo,
    private val floorService: FloorService,
    private val transitionConfigService: TransitionConfigService
) : TransitionService {
    override fun getAllTransitions(buildingId: Long, floorNumber: Int): List<Transition> {
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        return repo.findTransitionsByFloorId(floor.id)
    }

    @Transactional
    override fun createTransition(buildingId: Long, floorNumber: Int, transition: Transition): Long {
        if (transition.id != 0L){
            throw IllegalArgumentException("Transition id must be 0")
        }
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        transition.floor = floor
        val type = transitionConfigService.getTransitionTypeByName(transition.transitionType.name)
        transition.transitionType = type
        return repo.save(transition).id
    }

    @Transactional
    override fun updateTransition(buildingId: Long, floorNumber: Int, transition: Transition) {
        val saved = getTransitionById(transition.id)
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        if (saved.floor!!.id != floor.id) {
            throw TransitionNotExistException("Transition doesn't apply to floor $floorNumber")
        }
        transition.floor = floor
        val type = transitionConfigService.getTransitionTypeByName(transition.transitionType.name)
        transition.transitionType = type
        repo.save(transition)
    }


    override fun deleteTransition(buildingId: Long, floorNumber: Int, transitionId: Long) {
        val savedTransition = getTransitionById(transitionId)
        val floor = floorService.getFloorByNumber(buildingId, floorNumber)
        if (savedTransition.floor!!.id != floor.id) {
            throw TransitionNotExistException("Transition doesn't apply to floor $floorNumber")
        }
        repo.deleteById(transitionId)
    }

    override fun getTransitionById(id: Long): Transition {
        return repo.findTransitionsById(id) ?: throw TransitionNotExistException("Transition with id $id doesn't exist")
    }
}
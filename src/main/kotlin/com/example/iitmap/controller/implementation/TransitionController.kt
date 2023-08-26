package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.TransitionApi
import com.example.iitmap.models.Transition
import com.example.iitmap.services.TransitionService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TransitionController(private val service: TransitionService) : TransitionApi {
    override fun getAllTransitionOnFloor(buildingId: Long, floorNumber: Int): ResponseEntity<List<Transition>> {
        return ResponseEntity.ok(
            service.getAllTransitions(
                buildingId = buildingId,
                floorNumber = floorNumber
            )
        )
    }

    override fun createTransition(buildingId: Long, floorNumber: Int, transition: Transition): ResponseEntity<Long> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            service.createTransition(
                buildingId = buildingId,
                floorNumber = floorNumber,
                transition = transition
            )
        )
    }

    override fun updateTransition(
        buildingId: Long,
        floorNumber: Int,
        transitionId: Long,
        transition: Transition
    ): ResponseEntity<Void> {
        transition.id = transitionId
        service.updateTransition(
            buildingId = buildingId,
            floorNumber = floorNumber,
            transition = transition
        )
        return ResponseEntity.ok().build()
    }

    override fun deleteTransition(buildingId: Long, floorNumber: Int, transitionId: Long): ResponseEntity<Void> {
        service.deleteTransition(
            buildingId = buildingId,
            floorNumber = floorNumber,
            transitionId = transitionId
        )
        return ResponseEntity.ok().build()
    }
}
package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.TransitionApi
import com.example.iitmap.models.Transition
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TransitionController : TransitionApi {
    override fun getAllTransitionOnFloor(buildingId: Long, floorNumber: Int): ResponseEntity<List<Transition>> {
        TODO("Not yet implemented")
    }

    override fun createTransition(buildingId: Long, floorNumber: Int, transition: Transition): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    override fun updateTransition(
        buildingId: Long,
        floorNumber: Int,
        transitionId: Long,
        transition: Transition
    ): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    override fun deleteTransition(buildingId: Long, floorNumber: Int, transitionId: Long): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }
}
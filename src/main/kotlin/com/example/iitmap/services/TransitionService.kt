package com.example.iitmap.services

import com.example.iitmap.models.Transition

interface TransitionService {
    fun getAllTransitions(
        buildingId: Long,
        floorNumber: Int
    ): List<Transition>

    fun createTransition(
        buildingId: Long,
        floorNumber: Int,
        transition: Transition
    ): Long

    fun updateTransition(
        buildingId: Long,
        floorNumber: Int,
        transition: Transition
    )

    fun deleteTransition(
        buildingId: Long,
        floorNumber: Int,
        transitionId: Long
    )
}
package com.example.iitmap.repositories

import com.example.iitmap.models.Transition
import org.springframework.data.jpa.repository.JpaRepository

interface TransitionRepo : JpaRepository<Transition, Long> {
    fun findTransitionsByFloorId(floorId: Long): List<Transition>
    fun findTransitionsById(id: Long): Transition?
}
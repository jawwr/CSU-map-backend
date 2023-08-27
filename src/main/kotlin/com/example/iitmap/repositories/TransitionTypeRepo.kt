package com.example.iitmap.repositories

import com.example.iitmap.models.TransitionType
import org.springframework.data.jpa.repository.JpaRepository

interface TransitionTypeRepo : JpaRepository<TransitionType, Long> {
    fun findTransitionTypeByName(name: String): TransitionType?
    fun findTransitionTypeById(id: Long): TransitionType?
}
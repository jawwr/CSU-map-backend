package com.example.iitmap.services

import com.example.iitmap.models.TransitionType

interface TransitionConfigService {
    fun getAllTransitionTypes(): List<TransitionType>
    fun createTransitionType(type: TransitionType): Long
    fun updateTransitionType(typeId: Long, type: TransitionType)
    fun deleteTransitionType(typeId: Long)
}
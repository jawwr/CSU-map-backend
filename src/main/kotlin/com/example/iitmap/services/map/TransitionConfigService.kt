package com.example.iitmap.services.map

import com.example.iitmap.models.TransitionType

interface TransitionConfigService {
    fun getAllTransitionTypes(): List<TransitionType>
    fun createTransitionType(type: TransitionType): Long
    fun updateTransitionType(type: TransitionType)
    fun deleteTransitionType(typeId: Long)
    fun getTransitionTypeByName(name: String): TransitionType
    fun getTransactionTypeById(id: Long): TransitionType
}
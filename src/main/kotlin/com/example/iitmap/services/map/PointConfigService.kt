package com.example.iitmap.services.map

import com.example.iitmap.models.PointType

interface PointConfigService {
    fun getAllTypes(): List<PointType>
    fun createType(type: PointType): Long
    fun updateType(type: PointType)
    fun deleteType(typeId: Long)
    fun getTypeByName(name: String): PointType
}
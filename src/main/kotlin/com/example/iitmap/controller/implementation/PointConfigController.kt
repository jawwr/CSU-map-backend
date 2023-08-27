package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.PointConfigApi
import com.example.iitmap.models.PointType
import com.example.iitmap.services.PointConfigService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class PointConfigController(private val service: PointConfigService) : PointConfigApi {
    override fun createPointType(type: PointType): ResponseEntity<Long> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createType(type = type))
    }

    override fun getAllTypes(): ResponseEntity<List<PointType>> {
        return ResponseEntity.ok(service.getAllTypes())
    }

    override fun updateType(typeId: Long, type: PointType): ResponseEntity<Void> {
        type.id = typeId
        service.updateType(type = type)
        return ResponseEntity.ok().build()
    }

    override fun deleteType(typeId: Long): ResponseEntity<Void> {
        service.deleteType(typeId = typeId)
        return ResponseEntity.ok().build()
    }
}
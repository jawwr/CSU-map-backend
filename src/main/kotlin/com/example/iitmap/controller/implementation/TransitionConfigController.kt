package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.TransitionConfigApi
import com.example.iitmap.models.TransitionType
import com.example.iitmap.services.TransitionConfigService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TransitionConfigController(private val service: TransitionConfigService) : TransitionConfigApi {
    override fun getAllTransitionTypes(): ResponseEntity<List<TransitionType>> {
        return ResponseEntity.ok(service.getAllTransitionTypes())
    }

    override fun createTransitionType(type: TransitionType): ResponseEntity<Long> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTransitionType(type = type))
    }

    override fun updateTransitionType(typeId: Long, type: TransitionType): ResponseEntity<Void> {
        type.id = typeId
        service.updateTransitionType(
            typeId = typeId,
            type = type
        )
        return ResponseEntity.ok().build()
    }

    override fun deleteTransitionType(typeId: Long): ResponseEntity<Void> {
        service.deleteTransitionType(typeId = typeId)
        return ResponseEntity.ok().build()
    }
}
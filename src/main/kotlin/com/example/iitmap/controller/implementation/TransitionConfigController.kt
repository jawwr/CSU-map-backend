package com.example.iitmap.controller.implementation

import com.example.iitmap.controller.api.TransitionConfigApi
import com.example.iitmap.models.TransitionType
import com.example.iitmap.services.map.TransitionConfigService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
class TransitionConfigController(private val service: TransitionConfigService) : TransitionConfigApi {
    override fun getAllTransitionTypes(): ResponseEntity<List<TransitionType>> =
        ResponseEntity.ok(service.getAllTransitionTypes())

    override fun createTransitionType(type: TransitionType): ResponseEntity<Long> =
        ResponseEntity.status(HttpStatus.CREATED).body(service.createTransitionType(type = type))


    override fun updateTransitionType(typeId: Long, type: TransitionType): ResponseEntity<Void> {
        type.id = typeId
        service.updateTransitionType(
            type = type
        )
        return ResponseEntity.ok().build()
    }

    override fun deleteTransitionType(typeId: Long): ResponseEntity<Void> {
        service.deleteTransitionType(typeId = typeId)
        return ResponseEntity.ok().build()
    }
}
package com.example.iitmap.controller.api

import com.example.iitmap.models.PointType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/point/type")
interface PointConfigApi {
    @PostMapping
    fun createPointType(): ResponseEntity<Void>

    @GetMapping
    fun getAllTypes(): ResponseEntity<List<PointType>>

    @PutMapping("/{typeId}")
    fun updateType(
        @PathVariable("typeId") typeId: Long,
        @RequestBody type: PointType
    ): ResponseEntity<Void>

    @DeleteMapping("/{typeId}")
    fun deleteType(@PathVariable("typeId") typeId: Long): ResponseEntity<Void>
}
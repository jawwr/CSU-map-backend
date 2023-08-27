package com.example.iitmap.controller.api

import com.example.iitmap.models.PointType
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/point/type")
@Tag(name = "Api для конфига точек")
interface PointConfigApi {
    @PostMapping
    fun createPointType(@RequestBody type: PointType): ResponseEntity<Long>

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
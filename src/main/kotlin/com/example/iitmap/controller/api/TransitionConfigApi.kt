package com.example.iitmap.controller.api

import com.example.iitmap.models.TransitionType
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/transition/type")
@Tag(name = "Api для конфига переходов")
interface TransitionConfigApi {
    @GetMapping
    fun getAllTransitionTypes(): ResponseEntity<List<TransitionType>>

    @PostMapping
    fun createTransitionType(@RequestBody type: TransitionType): ResponseEntity<Long>

    @PutMapping("/{typeId}")
    fun updateTransitionType(
        @PathVariable("typeId") typeId: Long,
        @RequestBody type: TransitionType
    ): ResponseEntity<Void>

    @DeleteMapping("/{typeId}")
    fun deleteTransitionType(@PathVariable("typeId") typeId: Long): ResponseEntity<Void>
}
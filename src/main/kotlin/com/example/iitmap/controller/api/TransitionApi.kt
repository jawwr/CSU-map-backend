package com.example.iitmap.controller.api

import com.example.iitmap.models.Transition
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/building/{buildingId}/floor/{floorNumber}/transition")
@Tag(name = "Api для переходов")
interface TransitionApi {
    @GetMapping
    fun getAllTransitionOnFloor(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int
    ): ResponseEntity<List<Transition>>

    @PostMapping
    fun createTransition(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @RequestBody transition: Transition
    ): ResponseEntity<Long>

    @PutMapping("/{transitionId}")
    fun updateTransition(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @PathVariable("transitionId") transitionId: Long,
        @RequestBody transition: Transition
    ): ResponseEntity<Void>

    @DeleteMapping("/{transitionId}")
    fun deleteTransition(
        @PathVariable("buildingId") buildingId: Long,
        @PathVariable("floorNumber") floorNumber: Int,
        @PathVariable("transitionId") transitionId: Long
    ): ResponseEntity<Void>
}
package com.example.iitmap.controller

import com.example.iitmap.exceptions.*
import com.example.iitmap.models.util.ErrorMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandlerController {
    @ExceptionHandler(
        value = [
            BuildingNotExistException::class,
            FloorNotExistException::class,
            PointNotExistException::class,
            PointTypeAlreadyExistException::class,
            PointTypeNotExistException::class,
            TransitionNotExistException::class,
            TransitionTypeAlreadyExistException::class,
            TransitionTypeNotExistException::class
        ]
    )
    fun handleCustomException(e: RuntimeException): ResponseEntity<ErrorMessage> {
        log.error(e.message)
        return ResponseEntity.badRequest().body(ErrorMessage(e.message!!))
    }

    @ExceptionHandler(Exception::class)
    fun handleOtherException(e: Exception): ResponseEntity<Void> {
        log.error(e.message)
        return ResponseEntity.badRequest().build()
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
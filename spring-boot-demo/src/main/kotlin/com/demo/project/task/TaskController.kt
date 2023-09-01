package com.demo.project.task

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/tasks")
class TaskController(private val service: TaskService) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskResponse>> =
        ResponseEntity(service.getAllTasks(), HttpStatus.OK)

    @GetMapping("/open")
    fun getAllOpenTasks(): ResponseEntity<List<TaskResponse>> =
        ResponseEntity(service.getAllOpenTasks(), HttpStatus.OK)

    @GetMapping("/close")
    fun getAllClosedTasks(): ResponseEntity<List<TaskResponse>> =
        ResponseEntity(service.getAllClosedTasks(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): ResponseEntity<TaskResponse> =
        ResponseEntity(service.getTaskById(id), HttpStatus.OK)

    @PostMapping
    fun createTask(
        @Valid @RequestBody createRequest: TaskRequest
    ): ResponseEntity<TaskResponse> = ResponseEntity(service.createTask(createRequest), HttpStatus.CREATED)

    @PutMapping("/{id}")
    fun updateTask(
        @PathVariable id: Long,
        @Valid @RequestBody updateRequest: TaskRequest
    ): ResponseEntity<TaskResponse> = ResponseEntity(service.updateTask(id, updateRequest), HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): ResponseEntity<String> =
        ResponseEntity(service.deleteTask(id), HttpStatus.OK)

}
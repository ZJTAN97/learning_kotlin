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
import java.util.stream.Collectors

@RestController
@RequestMapping("api/v1/tasks")
class TaskController(
    private val service: TaskService,
    private val mapper: TaskMapper
) {

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskResponse>> =
        ResponseEntity(
            service.findAll().stream()
                .map(mapper::toDto).collect(
                    Collectors.toList()
                ),
            HttpStatus.OK
        )

    @GetMapping("/open")
    fun getAllOpenTasks(): ResponseEntity<List<TaskResponse>> =
        ResponseEntity(
            service.getAllOpenTasks().stream()
                .map(mapper::toDto).collect(
                    Collectors.toList()
                ),
            HttpStatus.OK
        )

    @GetMapping("/close")
    fun getAllClosedTasks(): ResponseEntity<List<TaskResponse>> =
        ResponseEntity(
            service.getAllClosedTasks().stream()
                .map(mapper::toDto).collect(
                    Collectors.toList()
                ),
            HttpStatus.OK
        )

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): ResponseEntity<TaskResponse> =
        ResponseEntity(mapper.toDto(service.getTaskById(id)), HttpStatus.OK)

    @PostMapping
    fun createTask(
        @Valid @RequestBody createRequest: TaskRequest
    ): ResponseEntity<TaskResponse> =
        ResponseEntity(
            mapper.toDto(service.create(mapper.toDomain(createRequest))),
            HttpStatus.CREATED
        )

    @PutMapping("/{id}")
    fun updateTask(
        @PathVariable id: Long,
        @Valid @RequestBody taskRequest: TaskRequest
    ): ResponseEntity<TaskResponse> {
        val task = mapper.toDomain(taskRequest)
        val updatedTask = service.update(id, task)

        return ResponseEntity(mapper.toDto(updatedTask), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long): ResponseEntity<String> =
        ResponseEntity(service.delete(id), HttpStatus.OK)

}
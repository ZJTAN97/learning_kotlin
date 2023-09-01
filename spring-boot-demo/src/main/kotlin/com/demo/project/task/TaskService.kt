package com.demo.project.task

import com.demo.project.common.BadRequestException
import com.demo.project.common.ResourceNotFoundException
import org.springframework.data.util.ReflectionUtils
import org.springframework.stereotype.Service
import java.lang.reflect.Field
import java.time.LocalDateTime
import java.util.stream.Collectors
import kotlin.reflect.full.memberProperties

@Service
class TaskService(private val repository: TaskRepository) {

    fun getAllTasks(): List<TaskResponse> =
        repository.findAll().stream().map(this::toDto).collect(Collectors.toList())

    fun getAllOpenTasks(): List<TaskResponse> =
        repository.queryAllOpenTasks().stream().map(this::toDto).collect(Collectors.toList())

    fun getAllClosedTasks(): List<TaskResponse> =
        repository.queryAllClosedTasks().stream().map(this::toDto).collect(Collectors.toList())

    fun getTaskById(id: Long): TaskResponse {
        checkForTaskId(id)
        val task: Task = repository.findTaskById(id)
        return toDto(task)
    }

    fun createTask(createRequest: TaskRequest): TaskResponse {
        if (repository.doesDescriptionExist(createRequest.description)) {
            throw BadRequestException("There is already a task with description: ${createRequest.description}")
        }
        val task = Task()
        toDomain(task, createRequest)
        val savedTask = repository.save(task)
        return toDto(savedTask)
    }

    fun updateTask(id: Long, updateRequest: TaskRequest): TaskResponse {
        checkForTaskId(id)
        val existingTask: Task = repository.findTaskById(id)

        existingTask.isTaskOpen = updateRequest.isTaskOpen
        existingTask.isReminderSet = updateRequest.isReminderSet
        existingTask.priority = updateRequest.priority
        existingTask.description = updateRequest.description
        existingTask.updatedOn = LocalDateTime.now()

        val savedTask: Task = repository.save(existingTask)
        return toDto(savedTask)
    }

    fun deleteTask(id: Long): String {
        checkForTaskId(id)
        repository.deleteById(id)
        return "Task with id: $id has been deleted."
    }


    // Private Mapping Methods
    private fun toDto(task: Task): TaskResponse {
        return TaskResponse(
            task.id,
            task.description,
            task.isReminderSet,
            task.isTaskOpen,
            task.createdOn,
            task.updatedOn,
            task.priority
        )
    }

    private fun toDomain(task: Task, taskRequest: TaskRequest) {
        task.description = taskRequest.description
        task.isReminderSet = taskRequest.isReminderSet
        task.isTaskOpen = taskRequest.isTaskOpen
        task.priority = taskRequest.priority
    }

    private fun checkForTaskId(id: Long) {
        if (!repository.existsById(id)) {
            throw ResourceNotFoundException("Task with ID: $id does not exist!")
        }
    }

}
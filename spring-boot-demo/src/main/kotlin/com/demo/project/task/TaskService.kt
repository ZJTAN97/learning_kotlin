package com.demo.project.task

import com.demo.project.common.BadRequestException
import com.demo.project.common.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TaskService(private val repository: TaskRepository) {

    fun findAll(): List<Task> = repository.findAll()

    fun getAllOpenTasks(): List<Task> = repository.queryAllOpenTasks()

    fun getAllClosedTasks(): List<Task> = repository.queryAllClosedTasks()

    fun getTaskById(id: Long): Task {
        checkForResource(id)

        return repository.findTaskById(id)
    }

    fun create(task: Task): Task {
        if (repository.doesDescriptionExist(task.description)) {
            throw BadRequestException("There is already a task with description: ${task.description}")
        }

        return repository.save(task)
    }

    fun update(id: Long, task: Task): Task {
        checkForResource(id)
        val existingTask: Task = repository.findTaskById(id)
        existingTask.description = task.description
        existingTask.isTaskOpen = task.isTaskOpen
        existingTask.priority = task.priority
        existingTask.isReminderSet = task.isReminderSet
        existingTask.updatedOn = LocalDateTime.now()

        return repository.save(existingTask)
    }

    fun delete(id: Long): String {
        checkForResource(id)
        repository.deleteById(id)

        return "Task with id: $id has been deleted."
    }

    private fun checkForResource(id: Long) {
        if (!repository.existsById(id)) {
            throw ResourceNotFoundException("Task with ID: $id does not exist!")
        }
    }

}
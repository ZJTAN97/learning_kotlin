package com.demo.project.task

import java.time.LocalDateTime

data class TaskResponse (
    val id: Long,
    val description: String,
    val isReminderSet: Boolean,
    val isTaskOpen: Boolean,
    val createdOn: LocalDateTime,
    val updatedOn: LocalDateTime,
    val priority: Priority
)
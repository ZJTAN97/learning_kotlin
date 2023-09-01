package com.demo.project.task

import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime

data class TaskRequest(
    @NotBlank(message = "description can't be empty")
    val description: String,

    val isReminderSet: Boolean,

    val isTaskOpen: Boolean,

    val priority: Priority
)

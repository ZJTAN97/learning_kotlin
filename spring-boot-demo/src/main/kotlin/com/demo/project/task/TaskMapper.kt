package com.demo.project.task

import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(componentModel = "spring")
interface TaskMapper {
    fun toDto(task: Task): TaskResponse
    fun toDomain(taskRequest: TaskRequest): Task
}
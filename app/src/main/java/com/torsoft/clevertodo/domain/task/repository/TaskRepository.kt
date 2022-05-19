package com.torsoft.clevertodo.domain.task.repository

import com.torsoft.clevertodo.domain.task.model.Task

interface TaskRepository {

    suspend fun loadTasks(): Result<List<Task>>

    suspend fun createTodo(text: String): Result<List<Task>>

    suspend fun removeTodo(id: Int): Result<List<Task>>

}

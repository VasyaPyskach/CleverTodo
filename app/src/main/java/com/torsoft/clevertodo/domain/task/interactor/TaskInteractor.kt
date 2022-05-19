package com.torsoft.clevertodo.domain.task.interactor

import com.torsoft.clevertodo.domain.task.model.Task

interface TaskInteractor {

    suspend fun getTodolist(): Result<List<Task>>

    suspend fun createTodo(text: String): Result<List<Task>>

    suspend fun removeTodo(id: Int): Result<List<Task>>

}

package com.torsoft.clevertodo.domain.task.interactor

import com.torsoft.clevertodo.domain.task.model.Task
import com.torsoft.clevertodo.domain.task.repository.TaskRepository

class TaskInteractorImpl(
    private val taskRepository: TaskRepository
) : TaskInteractor {

    override suspend fun getTodolist(): Result<List<Task>> {
        return taskRepository.loadTasks()
    }

    override suspend fun createTodo(text: String): Result<List<Task>> {
        return taskRepository.createTodo(text)
    }

    override suspend fun removeTodo(id: Int): Result<List<Task>> {
        return taskRepository.removeTodo(id)
    }

}

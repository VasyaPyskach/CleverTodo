package com.torsoft.clevertodo.data.task

import com.torsoft.clevertodo.domain.task.model.Task
import com.torsoft.clevertodo.domain.task.repository.TaskRepository

class TaskRepositoryImpl : TaskRepository {

    private val tasks = mutableListOf(
        Task(0, "Buy a car", false),
        Task(1, "Do homework", true),
        Task(2, "Drink the pill", true),
        Task(3, "Read book", false),
    )

    override suspend fun loadTasks(): Result<List<Task>> {
        return Result.success(tasks)
    }

    override suspend fun createTodo(text: String): Result<List<Task>> {
        Task(
            id = tasks.size,
            text = text,
            isDone = false
        ).apply {
            tasks.add(this)
        }

        return Result.success(tasks)
    }

    override suspend fun removeTodo(id: Int): Result<List<Task>> {
        tasks.removeIf { it.id == id }
        return Result.success(tasks)
    }
}

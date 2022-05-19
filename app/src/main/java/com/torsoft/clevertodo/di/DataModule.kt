package com.torsoft.clevertodo.di

import com.torsoft.clevertodo.data.login.LoginRepositoryImpl
import com.torsoft.clevertodo.data.task.TaskRepositoryImpl
import com.torsoft.clevertodo.data.token.TokenRepositoryImpl
import com.torsoft.clevertodo.domain.login.repository.LoginRepository
import com.torsoft.clevertodo.domain.login.repository.TokenRepository
import com.torsoft.clevertodo.domain.task.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun tokenRepository(): TokenRepository {
        return TokenRepositoryImpl()
    }

    @Provides
    @Singleton
    fun loginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }

    @Provides
    @Singleton
    fun taskRepository(): TaskRepository {
        return TaskRepositoryImpl()
    }

}

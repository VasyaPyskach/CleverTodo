package com.torsoft.clevertodo.di

import com.torsoft.clevertodo.domain.login.interactor.LoginInteractor
import com.torsoft.clevertodo.domain.login.interactor.LoginInteractorImpl
import com.torsoft.clevertodo.domain.login.repository.LoginRepository
import com.torsoft.clevertodo.domain.login.repository.TokenRepository
import com.torsoft.clevertodo.domain.task.interactor.TaskInteractor
import com.torsoft.clevertodo.domain.task.interactor.TaskInteractorImpl
import com.torsoft.clevertodo.domain.task.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun loginInteractor(
        tokenRepository: TokenRepository,
        loginRepository: LoginRepository
    ): LoginInteractor {
        return LoginInteractorImpl(
            tokenRepository = tokenRepository,
            loginRepository = loginRepository
        )
    }

    @Provides
    fun taskInteractor(taskRepository: TaskRepository): TaskInteractor {
        return TaskInteractorImpl(taskRepository)
    }

}

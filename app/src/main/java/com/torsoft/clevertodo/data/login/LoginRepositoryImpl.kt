package com.torsoft.clevertodo.data.login

import com.torsoft.clevertodo.domain.login.repository.LoginRepository
import kotlinx.coroutines.delay

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(domain: String): Result<String> {
        delay(2000)
        return Result.success("some_token")
    }
}

package com.torsoft.clevertodo.domain.login.repository

interface LoginRepository {

    suspend fun login(domain: String): Result<String>

}

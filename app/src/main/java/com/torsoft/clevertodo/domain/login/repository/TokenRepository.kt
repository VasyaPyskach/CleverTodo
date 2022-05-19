package com.torsoft.clevertodo.domain.login.repository

interface TokenRepository {

    suspend fun saveToken(token: String)

    suspend fun getToken(): String?

}

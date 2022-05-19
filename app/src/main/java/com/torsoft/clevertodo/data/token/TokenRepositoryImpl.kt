package com.torsoft.clevertodo.data.token

import com.torsoft.clevertodo.domain.login.repository.TokenRepository

class TokenRepositoryImpl : TokenRepository {

    private var token: String? = null

    override suspend fun saveToken(token: String) {
        this.token = token
    }

    override suspend fun getToken(): String? {
        return token
    }
}

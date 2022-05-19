package com.torsoft.clevertodo.domain.login.interactor

interface LoginInteractor {

    suspend fun isLogged(): Boolean

    suspend fun login(domain: String): Result<Unit>

}

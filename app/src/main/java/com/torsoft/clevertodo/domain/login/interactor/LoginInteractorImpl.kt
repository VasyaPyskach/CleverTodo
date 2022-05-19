package com.torsoft.clevertodo.domain.login.interactor

import com.torsoft.clevertodo.domain.login.repository.LoginRepository
import com.torsoft.clevertodo.domain.login.repository.TokenRepository
import javax.inject.Inject

class LoginInteractorImpl @Inject constructor(
    private val tokenRepository: TokenRepository,
    private val loginRepository: LoginRepository,
) : LoginInteractor {

    override suspend fun isLogged(): Boolean =
        tokenRepository.getToken() != null


    override suspend fun login(domain: String): Result<Unit> =
        loginRepository.login(domain = domain)
            .onSuccess { tokenRepository.saveToken(it) }
            .map { }

}

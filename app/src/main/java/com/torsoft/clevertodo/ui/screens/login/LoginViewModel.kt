package com.torsoft.clevertodo.ui.screens.login

import androidx.lifecycle.viewModelScope
import com.torsoft.clevertodo.R
import com.torsoft.clevertodo.domain.login.interactor.LoginInteractor
import com.torsoft.clevertodo.ui.screens.base.BaseViewModel
import com.torsoft.clevertodo.ui.validator.DomainValidator
import com.torsoft.clevertodo.ui.validator.base.fold
import com.torsoft.clevertodo.ui.validator.base.onFailure
import com.torsoft.clevertodo.ui.validator.base.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val domainValidator: DomainValidator,
    private val loginInteractor: LoginInteractor
) : BaseViewModel<LoginEvent, LoginState>(
    LoginState()
) {

    fun onDomainChanged(value: String) {
        viewState = viewState.copy(
            domain = value,
            domainError = null
        )
    }

    fun onLoginClicked() {
        domainValidator.validate(viewState.domain)
            .onSuccess { login() }
            .onFailure {
                viewState = viewState.copy(domainError = it)
            }
    }

    private fun login() {
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)

            withContext(Dispatchers.IO) {
                loginInteractor.login(viewState.domain)
            }.onSuccess {
                sendEvent(LoginEvent.NavigateToHome)
            }.onFailure {
                sendEvent(LoginEvent.ShowLoginError(R.string.login_error))
            }

            viewState = viewState.copy(isLoading = false)
        }
    }

}

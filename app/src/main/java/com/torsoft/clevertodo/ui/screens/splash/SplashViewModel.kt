package com.torsoft.clevertodo.ui.screens.splash

import androidx.lifecycle.viewModelScope
import com.torsoft.clevertodo.domain.login.interactor.LoginInteractor
import com.torsoft.clevertodo.ui.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val loginInteractor: LoginInteractor
) : BaseViewModel<SplashEvent, SplashState>(SplashState) {

    init {
        checkUserIsLogged()
    }

    private fun checkUserIsLogged() {
        viewModelScope.launch {
            if (loginInteractor.isLogged()) {
                SplashEvent.NavigateToHomeScreen
            } else {
                SplashEvent.NavigateToLoginScreen
            }.apply {
                sendEvent(this)
            }
        }
    }

}

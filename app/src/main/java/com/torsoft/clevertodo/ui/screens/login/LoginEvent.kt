package com.torsoft.clevertodo.ui.screens.login

sealed interface LoginEvent {

    object NavigateToHome : LoginEvent

    data class ShowLoginError(val messageResId: Int) : LoginEvent

}

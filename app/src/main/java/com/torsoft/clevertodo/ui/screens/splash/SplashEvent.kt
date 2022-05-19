package com.torsoft.clevertodo.ui.screens.splash

sealed interface SplashEvent {

    object NavigateToLoginScreen : SplashEvent

    object NavigateToHomeScreen : SplashEvent

}

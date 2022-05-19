package com.torsoft.clevertodo.ui.screens.login

data class LoginState(
    val isLoading: Boolean = false,
    val domain: String = "",
    val domainError: String? = null
)

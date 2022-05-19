package com.torsoft.clevertodo.ui.screens.login.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginView(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    domain: String,
    domainError: Int?,
    onDomainChanged: (String) -> Unit,
    onLoginClicked: () -> Unit
) {

}

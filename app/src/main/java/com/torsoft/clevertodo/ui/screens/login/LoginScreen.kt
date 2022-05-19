package com.torsoft.clevertodo.ui.screens.login

import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.torsoft.clevertodo.Routes
import com.torsoft.clevertodo.ui.screens.base.collectWithLifecycle
import com.torsoft.clevertodo.ui.screens.login.view.LoginView

@ExperimentalComposeUiApi
@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    val snackBarHostState = remember { SnackbarHostState() }

    viewModel.eventFlow.collectWithLifecycle(action = {
        when (it) {
            is LoginEvent.NavigateToHome -> {
                navController.navigate(Routes.home)
            }
            is LoginEvent.ShowLoginError -> {
                snackBarHostState.showSnackbar(message = it.message)
            }
        }
    })

    val state = viewModel.viewStateFlow.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        scaffoldState = rememberScaffoldState(snackbarHostState = snackBarHostState)
    ) {
        LoginView(
            isLoading = state.value.isLoading,
            domain = state.value.domain,
            domainError = state.value.domainError,
            onDomainChanged = {
                viewModel.onDomainChanged(it)
            },
            onLoginClicked = {
                keyboardController?.hide()
                viewModel.onLoginClicked()
            }
        )
    }

}

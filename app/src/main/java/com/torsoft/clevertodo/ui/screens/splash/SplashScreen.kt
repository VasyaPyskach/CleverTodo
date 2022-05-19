package com.torsoft.clevertodo.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.torsoft.clevertodo.Routes
import com.torsoft.clevertodo.ui.screens.base.collectWithLifecycle


@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel
) {
    splashViewModel.eventFlow.collectWithLifecycle(action = {
        when (it) {
            SplashEvent.NavigateToHomeScreen -> navController.navigate(Routes.home)
            SplashEvent.NavigateToLoginScreen -> navController.navigate(Routes.login)
        }
    })

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Splash Screen",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onBackground,
        )
    }

    LaunchedEffect(key1 = Unit){
        splashViewModel.onLaunched()
    }
}

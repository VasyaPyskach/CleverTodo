package com.torsoft.clevertodo.ui.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController


@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel
) {
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
}

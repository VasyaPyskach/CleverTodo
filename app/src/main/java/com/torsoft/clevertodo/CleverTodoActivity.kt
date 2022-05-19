package com.torsoft.clevertodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.torsoft.clevertodo.ui.screens.login.LoginScreen
import com.torsoft.clevertodo.ui.screens.splash.SplashScreen
import com.torsoft.clevertodo.ui.theme.CleverToDoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleverToDoTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.splash
                    ) {
                        composable(Routes.splash) {
                            SplashScreen(navController, hiltViewModel())
                        }
                        composable(Routes.login) {
                            LoginScreen(navController, hiltViewModel())
                        }

                    }
                }
            }
        }
    }

}

object Routes {
    const val splash = "splash"
    const val login = "login"
    const val home = "home"
}

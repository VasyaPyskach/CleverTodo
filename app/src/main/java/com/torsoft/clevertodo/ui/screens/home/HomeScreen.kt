package com.torsoft.clevertodo.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.torsoft.clevertodo.ui.screens.base.collectWithLifecycle
import com.torsoft.clevertodo.ui.screens.home.view.HomeLoadingView

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    homeViewModel.eventFlow.collectWithLifecycle(action = {

    })

    val state = homeViewModel.viewStateFlow.collectAsState()

    when (state.value) {
        HomeState.Loading -> HomeLoadingView()
        HomeState.Loading -> HomeLoadingView()
    }
}

package com.torsoft.clevertodo.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.torsoft.clevertodo.ui.screens.base.collectWithLifecycle
import com.torsoft.clevertodo.ui.screens.home.view.HomeDataView
import com.torsoft.clevertodo.ui.screens.home.view.HomeErrorView
import com.torsoft.clevertodo.ui.screens.home.view.HomeLoadingView

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    homeViewModel.eventFlow.collectWithLifecycle(action = {

    })

    when (val state = homeViewModel.viewStateFlow.collectAsState().value) {
        is HomeState.Loading -> HomeLoadingView()
        is HomeState.Data -> HomeDataView(
            items = state.items,
            onCheckChanged = { id, isChecked ->
                homeViewModel.onCheckChanged(id, isChecked)
            })
        is HomeState.Error -> HomeErrorView(
            message = state.message,
            onRetryClick = { homeViewModel.onRetryClick() }
        )
    }
}

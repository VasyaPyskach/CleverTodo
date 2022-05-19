package com.torsoft.clevertodo.ui.screens.home

import com.torsoft.clevertodo.ui.screens.home.view.HomeTodoItem

sealed interface HomeState {

    object Loading : HomeState

    data class Data(val items: List<HomeTodoItem>) : HomeState

    data class Error(val message: String) : HomeState

}

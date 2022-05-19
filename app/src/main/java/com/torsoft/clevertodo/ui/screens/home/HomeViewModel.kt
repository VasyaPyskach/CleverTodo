package com.torsoft.clevertodo.ui.screens.home

import com.torsoft.clevertodo.ui.screens.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

): BaseViewModel<HomeEvent, HomeState>(HomeState.Loading) {

    init {
        loadTodoList()
    }

    private fun loadTodoList(){

    }

}

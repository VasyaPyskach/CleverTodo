package com.torsoft.clevertodo.ui.screens.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<E, S>(initialState: S) : ViewModel() {

    protected var viewState: S
        get() = _viewStateFlow.value
        set(value) {
            _viewStateFlow.value = value
        }

    private val _viewStateFlow = MutableStateFlow(initialState)
    val viewStateFlow: StateFlow<S> = _viewStateFlow

    private val _eventFlow = MutableSharedFlow<E>()
    val eventFlow: SharedFlow<E> = _eventFlow

    protected fun sendEvent(event: E) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

}

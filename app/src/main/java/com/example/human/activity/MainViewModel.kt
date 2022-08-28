package com.example.human.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _stateFlow = MutableStateFlow(true)
    val stateFlow = _stateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _stateFlow.value = false
        }
    }
}
package org.work.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.work.project.model.api.AuthApi

class AuthViewModel: ViewModel() {
    private val _message = MutableStateFlow("")
    val message: StateFlow<String> = _message.asStateFlow()
    init {
        getMessage()
    }
    fun getMessage(){
        viewModelScope.launch {
            val result = AuthApi.getMessage()
            _message.value = result.message
        }
    }
}
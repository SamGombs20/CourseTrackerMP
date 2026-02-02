package org.work.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.work.project.model.api.AuthApi
import org.work.project.model.user.Token
import org.work.project.model.user.UserLogin

class AuthViewModel: ViewModel() {
    private val _message = MutableStateFlow("")
    private val _token = MutableStateFlow<Token?>(null)
    val token: StateFlow<Token?> = _token.asStateFlow()
    val message: StateFlow<String> = _message.asStateFlow()

    private val _logIn = MutableStateFlow(false)
    val logIn: StateFlow<Boolean> = _logIn.asStateFlow()


    fun getMessage(){
        viewModelScope.launch {
            val result = AuthApi.getMessage()
            _message.value = result.message
        }
    }
    fun signIn(username:String, password: String){
        viewModelScope.launch {
            val result = AuthApi.signIn(username, password)
            result.onSuccess {
                _token.value = it
                _logIn.value = true
            }
        }
    }
}
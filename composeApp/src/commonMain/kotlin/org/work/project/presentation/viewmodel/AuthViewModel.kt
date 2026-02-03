package org.work.project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.work.project.model.api.AuthApi
import org.work.project.model.user.SignInUiEvent
import org.work.project.model.user.SignInUiState
import org.work.project.model.user.Token
import org.work.project.model.user.UserLogin


class AuthViewModel: ViewModel() {
    private val _message = MutableStateFlow("")
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _uiEvents = Channel<SignInUiEvent>(Channel.BUFFERED)
    val uiEvents = _uiEvents.receiveAsFlow()
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
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            val result = AuthApi.signIn(username, password)
            _uiState.update { it.copy(isLoading = false) }
            when{
                result.isSuccess -> {
                    _token.value = result.getOrNull()!!
                    _logIn.value = true
                    _uiEvents.send(SignInUiEvent.NavigateToHome)
                }
                else->{
                    val msg = when{
                        result.exceptionOrNull()!=null -> result.exceptionOrNull()?.message?:""
                        else-> "Network Error"
                    }
                    _uiEvents.send(SignInUiEvent.ShowError(msg))
                }
            }
        }
    }
}
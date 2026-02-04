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
import org.work.project.api.AuthApi
import org.work.project.model.user.SignInUiEvent
import org.work.project.model.user.SignInUiState
import org.work.project.model.user.User
import org.work.project.utils.AuthTokenStorage


class AuthViewModel(private val tokenStorage: AuthTokenStorage, private val authApi: AuthApi): ViewModel() {
    private val _message = MutableStateFlow("")
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _uiEvents = Channel<SignInUiEvent>(Channel.BUFFERED)

    private val _token = MutableStateFlow("")
    val token: StateFlow<String> =_token.asStateFlow()
    val uiEvents = _uiEvents.receiveAsFlow()
    val message: StateFlow<String> = _message.asStateFlow()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()


    fun getMessage(){
        viewModelScope.launch {
            val result = authApi.getMessage()
            _message.value = result.message
        }
    }
    fun signIn(username:String, password: String){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            val result = authApi.signIn(username, password)
            _uiState.update { it.copy(isLoading = false) }
            when{
                result.isSuccess -> {
                    val token = result.getOrNull()!!
                    tokenStorage.saveTokens(token.accessToken, token.refreshToken)
                    _uiEvents.send(SignInUiEvent.NavigateToHome)
                    if (tokenStorage.getAccessToken()!=null){
                        _user.value = authApi.getUser()
                    }
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
    fun getAccessToken():String{
        return tokenStorage.getAccessToken()?:""
    }

    fun logOut(){
        viewModelScope.launch {
            _user.value = null
            tokenStorage.clearTokens()
            _uiEvents.send(SignInUiEvent.NavigateToHome)
        }
    }

}
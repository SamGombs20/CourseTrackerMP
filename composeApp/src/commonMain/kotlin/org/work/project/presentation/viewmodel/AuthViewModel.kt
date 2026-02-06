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
import org.work.project.model.user.AuthState
import org.work.project.model.user.SignInUiEvent
import org.work.project.model.user.SignInUiState
import org.work.project.model.user.User
import org.work.project.model.user.UserCreate
import org.work.project.utils.AuthTokenStorage


class AuthViewModel(private val tokenStorage: AuthTokenStorage, private val authApi: AuthApi): ViewModel() {
    private val _message = MutableStateFlow("")
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _uiEvents = Channel<SignInUiEvent>(Channel.BUFFERED)
    val event = _uiEvents.receiveAsFlow()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    fun getMessage(){
        viewModelScope.launch {
            val result = authApi.getMessage()
            _message.value = result.message
        }
    }
    fun signIn(username:String, password: String){
        viewModelScope.launch {
            tokenStorage.clearTokens()
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            val result = authApi.signIn(username, password)
            _uiState.update { it.copy(isLoading = false) }
            when{
                result.isSuccess -> {
                    val token = result.getOrNull()!!
                    tokenStorage.saveTokens(token.accessToken, token.refreshToken)
                    val usr = authApi.getUser()
                    _authState.value = AuthState.Authenticated(usr)
//                    _uiEvents.send(SignInUiEvent.NavigateToHome)
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
    fun signUp(firstName: String, lastName: String, username: String, password: String){
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            val usr = authApi.registerUser(UserCreate(
                firstName, lastName, username, password
            ))
            if (usr.firstName.isNotEmpty()){
                _uiState.update { it.copy(isLoading = false) }
                signIn(username, password)
            }
            else{
                _uiState.update { it.copy(isLoading = false, errorMessage = "Failed to register user") }

            }
        }
    }

    fun logOut(){
        viewModelScope.launch {
            tokenStorage.clearTokens()
            _authState.value = AuthState.Unauthenticated
//            _uiEvents.send(SignInUiEvent.NavigateToHome)
        }
    }

}
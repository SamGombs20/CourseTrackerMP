package org.work.project.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class UserCreate(
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
)
@Serializable
class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val username: String,
    val createdAt: String
)
@Serializable
class UserLogin(
    val username: String,
    val password: String
)

@Serializable
class Token(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("token_type")
    val tokenType: String
)
sealed interface SignInUiEvent{
    data object NavigateToHome: SignInUiEvent
    data class ShowError(val message: String): SignInUiEvent
}
data class SignInUiState(
    val isLoading: Boolean=false,
    val errorMessage:String?=null
)

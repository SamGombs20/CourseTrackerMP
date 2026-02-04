package org.work.project.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.http.encodedPath
import io.ktor.http.formUrlEncode
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.work.project.model.course.Message
import org.work.project.model.user.Token
import org.work.project.model.user.User
import org.work.project.utils.AuthTokenStorage

class AuthApi(private val tokenStorage: AuthTokenStorage){
    private val apiUrl = "https://course-tracker-fast-api.vercel.app"
    private val authUrl = "$apiUrl/api/v1"
    private val json = Json { ignoreUnknownKeys=true }
    private val  client = HttpClient(CIO) {
        install(Logging){
            level = LogLevel.INFO
        }
        install(ContentNegotiation){
            json(json)
        }
        install(Auth){
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = tokenStorage.getAccessToken()?:"",
                        refreshToken = tokenStorage.getRefreshToken()?:"",
                    )
                }
                refreshTokens {
                    val oldRefreshToken = oldTokens?.refreshToken?: return@refreshTokens null
                    val newToken: Token = refreshToken(oldRefreshToken)
                    tokenStorage.saveTokens(
                        accessToken = newToken.accessToken,
                        refreshToken = newToken.refreshToken
                    )
                    BearerTokens(
                        accessToken = newToken.accessToken,
                        refreshToken = newToken.refreshToken
                    )
                }
                sendWithoutRequest { request->
                    request.url.encodedPath in listOf("/auth/login", "/auth/register")
                }
            }
        }

    }
    suspend fun getMessage(): Message{
        return client.get(apiUrl).body()
    }

    suspend fun signIn(username:String, password: String): Result<Token> = runCatching{
        val response = client.post("$authUrl/auth/login") {
            contentType(ContentType.Application.FormUrlEncoded)

            setBody(
                Parameters.build {
                    append("username", username)
                    append("password", password)
                }.formUrlEncode()
            )
        }
        if (!response.status.isSuccess()){
            throw Exception("Invalid credentials")
        }
        response.body<Token>()
    }
    suspend fun refreshToken(refreshToken:String): Token{
        val response = client.post("$authUrl/auth/refresh"){
            contentType(ContentType.Application.Json)
            setBody(refreshToken)
        }
        if(response.status.isSuccess()){
            return response.body<Token>()
        }
        else{
            throw Exception("Failed to refresh token")
        }
    }
    suspend fun getUser(): User{
        val response = client.get("$authUrl/users/me")
        if(response.status.isSuccess()){
            return response.body<User>()
        }
        else{
            throw Exception("Failed to get user")
        }
    }
}
package org.work.project.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body

import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.http.formUrlEncode
import io.ktor.http.isSuccess
import org.work.project.model.course.Message
import org.work.project.model.user.Token
import org.work.project.model.user.User
import org.work.project.utils.AuthTokenStorage

class AuthApi(private val tokenStorage: AuthTokenStorage){
    val apiUrl = "https://course-tracker-fast-api.vercel.app"
    val authUrl = "$apiUrl/api/v1"
    private val client = Client(tokenStorage).client

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


    suspend fun getUser(): User{
        val response = client.get("$authUrl/users/me"){
            headers{
                append("Cache-control", "no-cache")
            }
        }
        if(response.status.isSuccess()){
            return response.body<User>()
        }
        else{
            throw Exception("Failed to get user")
        }
    }
}
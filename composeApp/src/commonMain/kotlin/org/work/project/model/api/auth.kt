package org.work.project.model.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.work.project.model.course.Message
import org.work.project.model.user.Token
import org.work.project.model.user.UserLogin

object AuthApi{
    private const val API_URL = "https://course-tracker-fast-api.vercel.app"
    private const val BASE_URL = "$API_URL/api/v1"
    private val json = Json { ignoreUnknownKeys=true }
    private val  client = HttpClient(CIO) {
        install(Logging){
            level = LogLevel.INFO
        }
        install(ContentNegotiation){
            json(json)
        }
    }
    suspend fun getMessage(): Message{
        return client.get(API_URL).body()
    }
    suspend fun login(user: UserLogin): Result<Token> = runCatching {
        val response = client.post("https://course-tracker-fast-api.vercel.app/api/v1/auth/login"){
            contentType(ContentType.Application.Json)
            setBody(user)
        }
        if(!response.status.isSuccess()){
            throw Exception("Login failed")
        }
        response.body<Token>()
    }
}
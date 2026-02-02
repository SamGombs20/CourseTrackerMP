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
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import io.ktor.http.formUrlEncode
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

    suspend fun signIn(username:String, password: String): Result<Token> = runCatching{
        val response = client.post("$BASE_URL/auth/login") {
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
}
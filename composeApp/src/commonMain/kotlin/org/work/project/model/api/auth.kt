package org.work.project.model.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.work.project.model.course.Message

object AuthApi{
    private const val API_URL = "https://course-tracker-fast-api.vercel.app/"
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
}
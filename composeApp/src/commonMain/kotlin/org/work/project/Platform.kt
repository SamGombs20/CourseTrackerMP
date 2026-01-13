package org.work.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
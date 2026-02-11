package org.work.project.utils

import dev.jordond.connectivity.Connectivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ConnectivityObserver {
    val status: Flow<Boolean>
}

class DefaultConnectivityObserver: ConnectivityObserver{
    private val connectivity = Connectivity{
        urls("8.8.8.8", "1.1.1.1")

    }
    override val status: Flow<Boolean> = connectivity.statusUpdates.map {
        it is Connectivity.Status.Connected
    }
    fun start(){connectivity.start()}
    fun stop(){connectivity.stop()}
}
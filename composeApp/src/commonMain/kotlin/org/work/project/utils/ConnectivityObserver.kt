package org.work.project.utils

import dev.jordond.connectivity.Connectivity
import dev.jordond.connectivity.compose.ConnectivityState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ConnectivityObserver {
    val status: Flow<Connectivity.Status>
}

class DefaultConnectivityObserver: ConnectivityObserver{
    private val connectivity = Connectivity()
    override val status: Flow<Connectivity.Status> = connectivity.statusUpdates
    fun start(){connectivity.start()}
    fun stop(){connectivity.stop()}
}
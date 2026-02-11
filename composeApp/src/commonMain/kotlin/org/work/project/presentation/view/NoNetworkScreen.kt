package org.work.project.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.no_internet
import coursetrackermp.composeapp.generated.resources.`try`
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.utils.DefaultConnectivityObserver

@Composable
fun NoInternetScreen(connectivityObserver: DefaultConnectivityObserver){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment= Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.no_internet),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error,
                modifier = Modifier.size(100 .dp)
            )
            Spacer(Modifier.height(16 .dp))
            Text(
                text = stringResource( Res.string.no_internet)
            )
            Spacer(Modifier.height(32 .dp))
            TextButton(
                onClick = {
                    connectivityObserver.start()
                }
            ){
                Text(
                    text = stringResource(Res.string.`try`)
                )
            }
        }
    }
}
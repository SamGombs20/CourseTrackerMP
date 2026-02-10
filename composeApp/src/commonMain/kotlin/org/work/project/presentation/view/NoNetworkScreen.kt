package org.work.project.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coursetrackermp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource

@Composable
fun NoInternetScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column {
            Icon(
                painter = painterResource(Res.drawable)
            )
        }
    }
}
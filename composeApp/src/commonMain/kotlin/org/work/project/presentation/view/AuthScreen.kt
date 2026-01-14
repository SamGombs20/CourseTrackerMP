package org.work.project.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.courseTracker
import coursetrackermp.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.ui.secondaryColor

@Composable
fun AuthScreen(){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.courseTracker),
                contentDescription = stringResource(Res.string.welcome),
                modifier = Modifier.size(20 .dp)
            )
            Row {
                Text(
                    text = "Course",
                    color = primaryColor
                )
                Text(
                    text = "Tracker",
                    color = secondaryColor
                )
            }
        }
        Spacer(Modifier.height(16 .dp))
        LogInScreen()

    }
}
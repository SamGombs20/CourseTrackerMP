package org.work.project.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.log_in
import coursetrackermp.composeapp.generated.resources.log_in_title
import coursetrackermp.composeapp.generated.resources.password_text
import coursetrackermp.composeapp.generated.resources.username_text
import org.jetbrains.compose.resources.stringResource
import org.work.project.presentation.components.CustomTextField
import org.work.project.presentation.ui.CourseTrackerTheme
import org.work.project.presentation.ui.secondaryColor

@Composable
fun LogInScreen(){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize().fillMaxWidth(0.5f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.log_in_title),
            fontSize = 18 .sp

        )
        Spacer(Modifier.height(16 .dp))
        CustomTextField(
            value = username,
            onChange = {
                username = it
            },
            label = stringResource(Res.string.username_text)

        )
        Spacer(Modifier.height(16 .dp))
        CustomTextField(
            value = password,
            onChange = {
                password = it
            },
            label = stringResource(Res.string.password_text)
        )
        Spacer(Modifier.height(16 .dp))
        TextButton(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.textButtonColors(
                containerColor = secondaryColor,
                contentColor = Color.White
            )


        ){
            Text(stringResource(Res.string.log_in))
        }
    }
}
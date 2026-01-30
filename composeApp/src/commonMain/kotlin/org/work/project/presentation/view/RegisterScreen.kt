package org.work.project.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.confirm
import coursetrackermp.composeapp.generated.resources.create
import coursetrackermp.composeapp.generated.resources.create_text
import coursetrackermp.composeapp.generated.resources.first_name
import coursetrackermp.composeapp.generated.resources.last_name
import coursetrackermp.composeapp.generated.resources.no_account
import coursetrackermp.composeapp.generated.resources.password_text
import coursetrackermp.composeapp.generated.resources.register
import coursetrackermp.composeapp.generated.resources.sign_in
import coursetrackermp.composeapp.generated.resources.username_text
import org.jetbrains.compose.resources.stringResource
import org.work.project.navigation.Screen
import org.work.project.presentation.components.CustomTextField
import org.work.project.presentation.ui.secondaryColor

@Composable
fun RegisterScreen (
    navController: NavController,
    pageToggle:(Boolean)-> Unit
){
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var confirmPassword by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier.fillMaxSize().padding(16 .dp).verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(Res.string.create),
            fontSize = 16 .sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(Res.string.create_text),
            fontSize = 12 .sp

        )
        Spacer(Modifier.height(8 .dp))
        CustomTextField(
            value = firstName,
            onChange = {
                firstName = it
            },
            label = stringResource(Res.string.first_name)

        )
        Spacer(Modifier.height(8 .dp))
        CustomTextField(
            value = lastName,
            onChange = {
                lastName = it
            },
            label = stringResource(Res.string.last_name)

        )
        Spacer(Modifier.height(8 .dp))
        CustomTextField(
            value = username,
            onChange = {
                username = it
            },
            label = stringResource(Res.string.username_text)

        )
        Spacer(Modifier.height(8 .dp))
        CustomTextField(
            value = password,
            onChange = {
                password = it
            },
            label = stringResource(Res.string.password_text)
        )
        Spacer(Modifier.height(8 .dp))
        CustomTextField(
            value = confirmPassword,
            onChange = {
                confirmPassword = it
            },
            label = stringResource(Res.string.confirm)

        )
        Spacer(Modifier.height(4 .dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = stringResource(Res.string.no_account),
                fontSize = 14 .sp
            )
            TextButton(
                onClick = {
                    pageToggle(false)
                },
                modifier = Modifier.padding(horizontal = 2 .dp, vertical = 2 .dp)

                ){
                Text(
                    text = stringResource(Res.string.sign_in)
                )
            }
        }
        Spacer(Modifier.height(4 .dp))
        TextButton(
            onClick = {
                navController.navigate(Screen.Main.route){
                    popUpTo(Screen.Login.route){
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(0.9f),
            colors = ButtonDefaults.textButtonColors(
                containerColor = secondaryColor,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(16 .dp)


        ){
            Text(stringResource(Res.string.register))
        }
    }
}
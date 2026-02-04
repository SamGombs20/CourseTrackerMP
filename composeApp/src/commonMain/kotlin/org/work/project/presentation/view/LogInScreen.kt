package org.work.project.presentation.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.log_in
import coursetrackermp.composeapp.generated.resources.log_in_title
import coursetrackermp.composeapp.generated.resources.no_account
import coursetrackermp.composeapp.generated.resources.password_text
import coursetrackermp.composeapp.generated.resources.sign_up
import coursetrackermp.composeapp.generated.resources.username_text
import coursetrackermp.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.work.project.model.user.SignInUiEvent
import org.work.project.navigation.Screen
import org.work.project.presentation.components.CustomTextField
import org.work.project.presentation.components.ErrorText
import org.work.project.presentation.ui.secondaryColor
import org.work.project.presentation.viewmodel.AuthViewModel

@Composable
fun LogInScreen(
    pageToggle:(Boolean)-> Unit,
    authViewModel: AuthViewModel
){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var usernameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    val state by authViewModel.uiState.collectAsStateWithLifecycle()
    var errorMessage by remember { mutableStateOf("") }

    fun validateInputs(): Boolean{
        var isValid = true
        if(username.isEmpty()){
            usernameError = "Username cannot be empty"
            isValid = false
        }
        else if(username.length<4){
            usernameError= "Username must have at least 4 characters"
            isValid = false
        }
        if (password.isEmpty()){
            passwordError = "Password cannot be empty"
            isValid = false
        }
        else if (password.length<6){
            passwordError = "Password must be at least 6 characters long"
            isValid =false
        }
        return  isValid
    }
        Column (
            modifier = Modifier.fillMaxSize().padding(16 .dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(Res.string.welcome),
                fontSize = 16 .sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(Res.string.log_in_title),
                fontSize = 12 .sp

            )
            Spacer(Modifier.height(16 .dp))
            CustomTextField(
                value = username,
                onChange = {
                    username = it
                    usernameError =""
                    errorMessage=""
                },
                label = stringResource(Res.string.username_text),
                isError = usernameError.isNotEmpty()
            )
            if(usernameError.isNotEmpty()){
                ErrorText(usernameError)
            }
            Spacer(Modifier.height(8 .dp))
            CustomTextField(
                value = password,
                onChange = {
                    password = it
                    passwordError = ""
                    errorMessage =""
                },
                isError = passwordError.isNotEmpty(),
                label = stringResource(Res.string.password_text)
            )
            if (passwordError.isNotEmpty()){
                ErrorText(passwordError)
            }
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
                        pageToggle(true)
                    },

                    ){
                    Text(
                        text = stringResource(Res.string.sign_up)
                    )
                }
            }
            if(errorMessage.isNotEmpty()){
                ErrorText(errorMessage)
            }
            Spacer(Modifier.height(16 .dp))
            TextButton(
                onClick = {
                    if(validateInputs()){
                        authViewModel.signIn(username, password)
                    }
                },
                enabled = !state.isLoading,
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = secondaryColor,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16 .dp)


            ){
                if (state.isLoading){
                    CircularProgressIndicator(modifier = Modifier.size(24 .dp))
                }
                else{
                    Text(stringResource(Res.string.log_in))
                }
            }
        }

}
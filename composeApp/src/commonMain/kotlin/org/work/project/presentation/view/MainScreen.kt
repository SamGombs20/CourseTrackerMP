package org.work.project.presentation.view

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.app_name
import coursetrackermp.composeapp.generated.resources.sign_out
import org.jetbrains.compose.resources.stringResource
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.ui.secondaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(Res.string.app_name)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = primaryColor,
                    titleContentColor = Color.White
                ),
                actions = {
                    TextButton(
                        onClick = {

                        },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = secondaryColor,
                            contentColor = Color.White
                        )
                    ){
                        Text(
                            text = stringResource(Res.string.sign_out)
                        )
                    }
                }
            )
        },
    ){

    }
}
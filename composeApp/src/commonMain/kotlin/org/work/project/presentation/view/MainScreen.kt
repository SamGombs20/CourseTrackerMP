package org.work.project.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
                    Row {
                        Text(
                            text = "Course",
                            color = secondaryColor
                        )
                        Text(
                            text = "Tracker",
                            color = Color.White
                        )
                    }
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
                            containerColor = Color.White,
                            contentColor = secondaryColor
                        ),
                        shape = RoundedCornerShape(20 .dp)
                    ){
                        Text(
                            text = stringResource(Res.string.sign_out),
                            modifier = Modifier.padding(vertical = (2).dp, horizontal = 8 .dp)
                        )
                    }
                }
            )
        },
        content = { innerPadding->
            Column(
                modifier = Modifier.padding(innerPadding).background(Color.White).fillMaxSize()
            ) {
                HomeScreen()
            }
        }
    )
}
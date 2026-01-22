package org.work.project.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.arrow_down
import coursetrackermp.composeapp.generated.resources.sign_out
import org.jetbrains.compose.resources.painterResource
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
                            text = "Tracker"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = primaryColor
                ),
                actions = {
//                    TextButton(
//                        onClick = {
//
//                        },
//                        colors = ButtonDefaults.textButtonColors(
//                            containerColor = primaryColor,
//                            contentColor = Color.White
//                        ),
//                        shape = RoundedCornerShape(20 .dp)
//                    ){
//                        Text(
//                            text = stringResource(Res.string.sign_out),
//                            modifier = Modifier.padding(vertical = (2).dp, horizontal = 8 .dp)
//                        )
//                    }
                    Row {
                        Box(
                            modifier = Modifier.size(50 .dp).padding(8 .dp).background(
                                color = secondaryColor,
                                shape = RoundedCornerShape(8 .dp)
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "J",
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
                        Column {
                            Text(
                                text = "Joshua"
                            )
                            Text(
                                text = "Omondi"
                            )
                        }
                        IconButton(
                            onClick = {}
                        ){
                            Icon(
                                painter = painterResource(Res.drawable.arrow_down),
                                contentDescription = stringResource(Res.string.sign_out),
                                tint = primaryColor
                            )
                        }
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
package org.work.project.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
//
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier.size(55 .dp).padding(8 .dp).background(
                                color = secondaryColor,
                                shape = CircleShape
                            ),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "J",
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                        }
//
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
package org.work.project.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.active_courses
import org.jetbrains.compose.resources.stringResource
import org.work.project.presentation.ui.secondaryColor

@Composable
fun HomeScreen(){
    Column {
        Box(

        ){
            Row {
                Row {
                    Column {

                        Text(
                            text = stringResource(Res.string.active_courses)
                        )
                        Text(
                            text = "16"
                        )
                    }
                }
            }
        }
    }
}
package org.work.project.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import org.work.project.presentation.ui.secondaryColor

@Composable
fun HomeScreen(){
    Column {
        Row {
            Text(
                text = "Hello,"
            )
            Text(
                text = "Name",
                color = secondaryColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
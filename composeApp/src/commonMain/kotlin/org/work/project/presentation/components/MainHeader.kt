package org.work.project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.completed
import coursetrackermp.composeapp.generated.resources.my_courses
import coursetrackermp.composeapp.generated.resources.pending
import coursetrackermp.composeapp.generated.resources.progress
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.Category

@Composable
fun MainHeader(){
    var selectedOption by remember{ mutableStateOf("") }
    val selectionOptions = listOf<Category>(
        Category(
            Res.drawable.pending, "Not Started"
        ),
        Category(
            Res.drawable.progress, "In Progress"
        ),
        Category(
            Res.drawable.completed, "Completed"
        ),

    )
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(Res.string.my_courses),
            fontSize = 28 .sp,
            fontWeight = FontWeight.SemiBold
        )
        Row {

        }
    }
}
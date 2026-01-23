package org.work.project.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.my_courses
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainHeader(){
    Row {
        Text(
            text = stringResource(Res.string.my_courses),
            fontSize = 28 .sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
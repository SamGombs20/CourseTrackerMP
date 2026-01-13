package org.work.project.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    value: String,
    onChange:(String)-> Unit,
    label: String,
    modifier: Modifier = Modifier
){
    Column {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            label ={Text(label)},
            onValueChange = onChange,
            shape = RoundedCornerShape(16 .dp)
        )
    }
}
package org.work.project.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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
            label = {label},
            onValueChange = onChange
        )
    }
}
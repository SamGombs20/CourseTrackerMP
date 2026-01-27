package org.work.project.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.category
import coursetrackermp.composeapp.generated.resources.description
import coursetrackermp.composeapp.generated.resources.end_date
import coursetrackermp.composeapp.generated.resources.name
import coursetrackermp.composeapp.generated.resources.rating
import coursetrackermp.composeapp.generated.resources.start_date
import coursetrackermp.composeapp.generated.resources.status
import org.jetbrains.compose.resources.stringResource

@Composable
fun AddCourse(){
    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("")}
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("")}
    var rating by remember { mutableStateOf("")}

    Column(
    ) {



            CustomTextField(
                value = name,
                onChange = {
                    name = it
                },
                label = stringResource(Res.string.name)
            )
            Spacer(Modifier.height(8 .dp))
        }

            CustomTextField(
                value = category,
                onChange = {
                    category = it
                },
                label = stringResource(Res.string.category)
            )
            Spacer(Modifier.height(8 .dp))

            CustomTextField(
                value = description,
                onChange = {
                    description=it
                },
                label = stringResource(Res.string.description)
            )
            Spacer(Modifier.height(8 .dp))

            CustomTextField(
                value = status,
                onChange = {
                    status = it
                },
                label = stringResource(Res.string.status)
            )
            Spacer(Modifier.height(16 .dp))

            CustomTextField(
                value = startDate,
                onChange = {
                    startDate = it
                },
                label = stringResource(Res.string.start_date)
            )
            Spacer(Modifier.height(16 .dp))

            CustomTextField(
                value = endDate,
                onChange = {
                    endDate = it
                },
                label = stringResource(Res.string.end_date)
            )
            Spacer(Modifier.height(16 .dp))

            CustomTextField(
                value = rating,
                onChange = {
                    rating= it
                },
                label = stringResource(Res.string.rating)
            )
            Spacer(Modifier.height(16 .dp))

    }
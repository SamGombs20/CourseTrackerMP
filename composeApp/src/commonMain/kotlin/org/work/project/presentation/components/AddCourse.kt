package org.work.project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.calendar
import coursetrackermp.composeapp.generated.resources.category
import coursetrackermp.composeapp.generated.resources.close
import coursetrackermp.composeapp.generated.resources.description
import coursetrackermp.composeapp.generated.resources.end_date
import coursetrackermp.composeapp.generated.resources.name
import coursetrackermp.composeapp.generated.resources.rating
import coursetrackermp.composeapp.generated.resources.save
import coursetrackermp.composeapp.generated.resources.start_date
import coursetrackermp.composeapp.generated.resources.status
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.Course
import org.work.project.presentation.ui.secondaryColor
import org.work.project.presentation.viewmodel.CourseViewModel

@Composable
fun AddCourse(onClose:(Boolean)-> Unit, courseViewModel: CourseViewModel= viewModel()){
    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("")}
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("")}
    var rating by remember { mutableStateOf("")}
    var showStartDate by remember { mutableStateOf(false) }
    var showEndDate by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = name,
            onChange = {
                name = it
            },
            label = stringResource(Res.string.name)
        )
        Spacer(Modifier.height(8.dp))


        CustomTextField(
            value = category,
            onChange = {
                category = it
            },
            label = stringResource(Res.string.category)
        )
        Spacer(Modifier.height(8.dp))

        CustomTextField(
            value = description,
            onChange = {
                description = it
            },
            label = stringResource(Res.string.description)
        )
        Spacer(Modifier.height(8.dp))

        CustomTextField(
            value = status,
            onChange = {
                status = it
            },
            label = stringResource(Res.string.status)
        )
        Spacer(Modifier.height(16.dp))

        CustomTextField(
            value = startDate,
            onChange = {
                startDate = it
            },
            readOnly = true,
            trailingIcon = {
                IconButton(
                    onClick = {
                        showStartDate =true
                    }
                ){
                    Icon(
                        painter = painterResource(Res.drawable.calendar),
                        contentDescription = null
                    )
                }
            },
            label = stringResource(Res.string.start_date)
        )
        Spacer(Modifier.height(16.dp))

        CustomTextField(
            value = endDate,
            readOnly = true,
            onChange = {
                endDate = it
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        showEndDate = true
                    }
                ){
                    Icon(
                        painter = painterResource(Res.drawable.calendar),
                        contentDescription = null
                    )
                }
            },
            label = stringResource(Res.string.end_date)
        )
        Spacer(Modifier.height(16.dp))

        CustomTextField(
            value = rating,
            onChange = {
                rating = it
            },
            label = stringResource(Res.string.rating)
        )
        Spacer(Modifier.height(16.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ){
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    onClick = {
                        onClose(true)
                    }
                ) {
                    Text(
                        text = stringResource(Res.string.close)
                    )
                }
                TextButton(
                    onClick = {
                        courseViewModel.addCourse(
                            Course(
                                id = "c00",
                                name,
                                category,
                                description,
                                status,
                                startDate,
                                endDate,
                                rating
                            )
                        )
                        onClose(true)
                    },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = secondaryColor,
                        contentColor = Color.White
                    ),
                    contentPadding = PaddingValues( 4 .dp)
                ) {
                    Text(
                        text = stringResource(Res.string.save)
                    )
                }
            }
        }
        if (showStartDate){
            DatePickerModal(
                onDateSelected = {

                },
                onDismiss = {showStartDate=false}
            )
        }
        if(showEndDate){
            DatePickerModal(
                onDateSelected = {},
                onDismiss = {
                    showEndDate = false
                }
            )
        }
    }
}
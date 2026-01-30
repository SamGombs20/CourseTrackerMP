package org.work.project.presentation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.course_details
import coursetrackermp.composeapp.generated.resources.danger
import coursetrackermp.composeapp.generated.resources.delete
import coursetrackermp.composeapp.generated.resources.edit
import coursetrackermp.composeapp.generated.resources.edit_course
import coursetrackermp.composeapp.generated.resources.no
import coursetrackermp.composeapp.generated.resources.sure
import coursetrackermp.composeapp.generated.resources.trash
import coursetrackermp.composeapp.generated.resources.yes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.presentation.components.Banner
import org.work.project.presentation.components.ButtonWithIcon
import org.work.project.presentation.components.Course
import org.work.project.presentation.components.CourseDetails
import org.work.project.presentation.components.EditCourse
import org.work.project.presentation.components.MainHeader
import org.work.project.presentation.components.TitleWithIcon
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.ui.secondaryColor
import org.work.project.presentation.viewmodel.CourseViewModel


@Composable
fun HomeScreen(courseViewModel: CourseViewModel){

    val courses by courseViewModel.courseList.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var showDeleteAlert by remember { mutableStateOf(false) }
    val selectedCourse by courseViewModel.selectedCourse.collectAsStateWithLifecycle()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200 .dp),
        modifier = Modifier.padding(16 .dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column {
                Banner(courseViewModel)
                Spacer(Modifier.height(16 .dp))
            }
        }
        item(span = {GridItemSpan(maxLineSpan)}) {
            Column {
                MainHeader(courseViewModel)
                Spacer(Modifier.height(24 .dp))
            }
        }
        item(span = {GridItemSpan(maxLineSpan)}) {
            Column {
                HorizontalDivider(color = primaryColor)
                Spacer(Modifier.height(8 .dp))
            }
        }
        items(courses){ course->
            Course(course){
                courseViewModel.setSelectedCourse(course)
                showDialog = true
            }
        }

    }
    if (showDialog && selectedCourse!=null){

        Dialog(
            onDismissRequest = {
                showDialog = false
                courseViewModel.setSelectedCourse(null)
            }
        ){
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16 .dp)
                ) {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                        TitleWithIcon(stringResource(Res.string.course_details), Res.drawable.course_details)
                    }
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        item {
                            CourseDetails(selectedCourse!!)
                            Spacer(Modifier.height(16 .dp))
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.BottomEnd
                            ){
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(8 .dp)
                                ) {
                                    ButtonWithIcon(
                                        stringResource(Res.string.edit),
                                        Res.drawable.edit,
                                        onClick = {
                                            showEditDialog = true
                                        }
                                    )
                                    ButtonWithIcon(
                                        stringResource(Res.string.delete),
                                        Res.drawable.trash,
                                        onClick = {
                                            showDeleteAlert = true
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


    }
    if (showEditDialog){
        Dialog(
            onDismissRequest = {
                showEditDialog = false
            }
        ){
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(modifier = Modifier.padding(16 .dp)) {
                    Text(
                        text = stringResource(Res.string.edit_course),
                        fontSize = 22 .sp,
                        fontWeight = FontWeight.SemiBold,
                        color = secondaryColor,
                        modifier = Modifier.padding(16 .dp).fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    LazyColumn {
                        item {
                            selectedCourse?.let {
                                EditCourse(
                                    onClose = {
                                        showEditDialog=false
                                        showDialog = false
                                        courseViewModel.setSelectedCourse(null)
                                    },
                                    course = it, courseViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
    if(showDeleteAlert){
        AlertDialog(
            onDismissRequest = {
                showDeleteAlert = false
            },
            containerColor = Color.White,
            confirmButton = {
                TextButton(
                    onClick = {
                        selectedCourse?.let {
                            courseViewModel.deleteCourse(it)
                            showDialog =false
                            showDeleteAlert = false
                            courseViewModel.setSelectedCourse(null)
                        }
                    }
                ){
                    Text(
                        text = stringResource(Res.string.yes)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDeleteAlert = false
                    }
                ){
                    Text(
                        text = stringResource(Res.string.no)
                    )
                }
            },
            icon = {
                Icon(
                    painter = painterResource(Res.drawable.danger),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(40 .dp)
                )
            },
            title = {
                Text(
                    text = stringResource(Res.string.sure)
                )
            }
        )
    }
}
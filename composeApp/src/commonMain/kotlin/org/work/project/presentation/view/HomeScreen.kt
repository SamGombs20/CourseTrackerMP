package org.work.project.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.course_details
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.Course
import org.work.project.presentation.components.Banner
import org.work.project.presentation.components.Course
import org.work.project.presentation.components.CourseDetails
import org.work.project.presentation.components.MainHeader
import org.work.project.presentation.components.TitleWithIcon
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.viewmodel.CourseViewModel


@Composable
fun HomeScreen(courseViewModel: CourseViewModel= viewModel()){

    val courses by courseViewModel.courseList.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }
    val selectedCourse by courseViewModel.selectedCourse.collectAsStateWithLifecycle()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200 .dp),
        modifier = Modifier.padding(16 .dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            Column {
                Banner()
                Spacer(Modifier.height(16 .dp))
            }
        }
        item(span = {GridItemSpan(maxLineSpan)}) {
            Column {
                MainHeader()
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
                    CourseDetails(selectedCourse!!)
                }
            }
        }

    }
}
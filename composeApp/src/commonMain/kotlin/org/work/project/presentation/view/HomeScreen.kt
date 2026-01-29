package org.work.project.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.work.project.presentation.components.Banner
import org.work.project.presentation.components.Course
import org.work.project.presentation.components.MainHeader
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.viewmodel.CourseViewModel


@Composable
fun HomeScreen(courseViewModel: CourseViewModel= viewModel()){

    val courses by courseViewModel.courseList.collectAsStateWithLifecycle()
    LaunchedEffect(courses){

    }
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
            }
        }
    }
}
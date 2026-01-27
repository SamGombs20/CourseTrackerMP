package org.work.project.presentation.components

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.work.project.model.courses

@Composable
fun CourseList(){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180 .dp)
    ){
        items(courses){ course->
            Course(course)
        }
    }
}
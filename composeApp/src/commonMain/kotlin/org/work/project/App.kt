package org.work.project


import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.work.project.presentation.ui.CourseTrackerTheme
import org.work.project.presentation.view.MainScreen


@Composable
@Preview
fun App() {
    CourseTrackerTheme {
        MainScreen()
    }
}
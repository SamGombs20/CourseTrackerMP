package org.work.project


import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.work.project.navigation.RootNavigation
import org.work.project.presentation.ui.CourseTrackerTheme

@Composable
@Preview
fun App() {
    CourseTrackerTheme {
        RootNavigation()
    }
}
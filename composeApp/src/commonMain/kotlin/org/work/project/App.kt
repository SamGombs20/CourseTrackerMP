package org.work.project


import androidx.compose.runtime.*
import org.work.project.navigation.RootNavigation
import org.work.project.presentation.ui.CourseTrackerTheme

@Composable
fun App() {
    CourseTrackerTheme {
        RootNavigation()
    }
}
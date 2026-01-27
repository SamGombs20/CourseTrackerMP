package org.work.project.utils

import androidx.compose.ui.graphics.Color
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.completed
import coursetrackermp.composeapp.generated.resources.pending
import coursetrackermp.composeapp.generated.resources.progress
import org.jetbrains.compose.resources.DrawableResource
import org.work.project.presentation.ui.completed
import org.work.project.presentation.ui.completedLight
import org.work.project.presentation.ui.inProgress
import org.work.project.presentation.ui.inProgressLight
import org.work.project.presentation.ui.lightSecondaryColor
import org.work.project.presentation.ui.secondaryColor

fun getStatusIcon(status: String): DrawableResource{
    return when(status){
        "Not Started"-> Res.drawable.pending
        "In Progress"-> Res.drawable.progress
        "Completed"-> Res.drawable.completed
        else -> Res.drawable.pending
    }
}
fun getStatusColor(status: String): Color{
    return when(status){
        "Not Started"-> secondaryColor
        "In Progress"-> inProgress
        "Completed"-> completed
        else -> secondaryColor
    }
}
fun getStatusBackground(status: String): Color{
    return when(status){
        "Not Started"-> lightSecondaryColor
        "In Progress"-> inProgressLight
        "Completed"-> completedLight
        else -> lightSecondaryColor
    }
}

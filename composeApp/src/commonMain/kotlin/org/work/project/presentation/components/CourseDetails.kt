package org.work.project.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.category
import coursetrackermp.composeapp.generated.resources.description
import coursetrackermp.composeapp.generated.resources.duration
import coursetrackermp.composeapp.generated.resources.name
import coursetrackermp.composeapp.generated.resources.rating
import coursetrackermp.composeapp.generated.resources.status
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.course.Course
import org.work.project.utils.getStatusBackground
import org.work.project.utils.getStatusColor

@Composable
fun CourseDetails(course: Course){
    Column {
        DetailsTitle(
            title = stringResource(Res.string.name)
        )
        DetailsText(
            course.name
        )
        DetailsTitle(stringResource(Res.string.category))
        DetailsText(course.category)
        DetailsTitle(stringResource(Res.string.description))
        DetailsText(course.description)
        DetailsTitle(stringResource(Res.string.status))
        Box(
            modifier = Modifier
                .background(getStatusBackground(course.status),
                    RoundedCornerShape(16 .dp)).padding(6 .dp, 4.dp)

        ){
            DetailsText(course.status, getStatusColor(course.status))
        }
        DetailsTitle(stringResource(Res.string.duration))
        Row {
            DetailsText(course.startDate)
            if(course.endDate.isNotEmpty()){
                DetailsText(" - ")
                DetailsText(course.endDate)
            }
        }
        DetailsTitle(stringResource(Res.string.rating))
        DetailsText(course.rating)
    }
}

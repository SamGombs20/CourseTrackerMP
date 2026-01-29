package org.work.project.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.work.project.model.Course
import org.work.project.presentation.ui.lightGray
import org.work.project.presentation.ui.primaryColor
import org.work.project.utils.getStatusBackground
import org.work.project.utils.getStatusColor
import org.work.project.utils.getStatusIcon

@Composable
fun Course(course: Course, onClick:()-> Unit){
    Column (
        modifier = Modifier.padding(8 .dp).width(200 .dp).shadow(
            elevation = 10 .dp,
            shape = RoundedCornerShape(16 .dp)
        ).background(Color.White).clickable(onClick ={onClick()})
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(120 .dp).padding(6 .dp).background(
                color = primaryColor,
                shape = RoundedCornerShape(16 .dp)
            ),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = course.name,
                fontSize = 18 .sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16 .dp)
            )
        }
        Column(
            modifier = Modifier.padding(6 .dp)
        ) {
            Box(
                modifier = Modifier
                    .background(lightGray, RoundedCornerShape(16 .dp))
                    .padding(8 .dp, 2 .dp)
            ){
                Text(
                    text = course.category,
                    fontSize = 11 .sp
                )
            }
            Spacer(Modifier.height(6 .dp))
            Text(
                text = course.description.take(51)+"...",
                fontSize = 13 .sp
            )
            Spacer(Modifier.height(8 .dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6 .dp),
                modifier = Modifier.background(
                    getStatusBackground(course.status), RoundedCornerShape(16 .dp)
                ).padding(4 .dp, 0 .dp).align(Alignment.End)
            ) {
                Icon(
                    painter = painterResource(getStatusIcon(course.status)),
                    contentDescription = null,
                    tint = getStatusColor(course.status),
                    modifier = Modifier.size(12 .dp)
                )
                Text(
                    text = course.status,
                    color = getStatusColor(course.status),
                    fontSize = 10 .sp
                )
            }
        }
    }
}
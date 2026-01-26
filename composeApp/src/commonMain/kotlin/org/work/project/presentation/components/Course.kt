package org.work.project.presentation.components

import androidx.compose.foundation.background
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
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.progress
import org.jetbrains.compose.resources.painterResource
import org.work.project.presentation.ui.inProgress
import org.work.project.presentation.ui.inProgressLight
import org.work.project.presentation.ui.primaryColor

@Composable
fun Course(){
    Column (
        modifier = Modifier.padding(8 .dp).width(250 .dp).shadow(
            elevation = 10 .dp,
            shape = RoundedCornerShape(16 .dp)
        ).background(Color.White)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().height(120 .dp).padding(6 .dp).background(
                color = primaryColor,
                shape = RoundedCornerShape(16 .dp)
            ),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = "Introduction to Android Development",
                fontSize = 18 .sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16 .dp)
            )
        }
        Column(
            modifier = Modifier.padding(6 .dp)
        ) {
            Text(
                text = "Learnt to develop android mobile apps with jetpack compose..",
                fontSize = 14 .sp
            )
            Spacer(Modifier.height(16 .dp))
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6 .dp),
                modifier = Modifier.background(
                    inProgressLight, RoundedCornerShape(16 .dp)
                ).padding(4 .dp, 0 .dp).align(Alignment.End)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.progress),
                    contentDescription = null,
                    tint = inProgress,
                    modifier = Modifier.size(12 .dp)
                )
                Text(
                    text = "In Progress",
                    color = inProgress,
                    fontSize = 10 .sp
                )
            }
        }
    }
}
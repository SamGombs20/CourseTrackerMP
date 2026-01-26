package org.work.project.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import org.work.project.presentation.ui.primaryColor

@Composable
fun Course(){
    Column (
        modifier = Modifier.width(300 .dp).shadow(
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
                text = "Introduction to Computing",
                fontSize = 22 .sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(start = 16 .dp)
            )
        }
        Text(
            text = "Learnt to develop android mobile apps with jetpack compose, a component-based kotlin library for developing the UI"
        )
        Row (

        ) {
            Icon(
                painter = painterResource(Res.drawable.progress),
                contentDescription = null
            )
            Text(
                text = "In Progress"
            )
        }
    }
}
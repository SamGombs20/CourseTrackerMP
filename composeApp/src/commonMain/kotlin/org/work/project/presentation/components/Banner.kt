package org.work.project.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.active_courses
import coursetrackermp.composeapp.generated.resources.add
import coursetrackermp.composeapp.generated.resources.add_course
import coursetrackermp.composeapp.generated.resources.course
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.courses
import org.work.project.presentation.ui.lightPrimaryColor
import org.work.project.presentation.ui.lightSecondaryColor
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.ui.secondaryColor

@Composable
fun Banner(){
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxWidth().height(120 .dp).background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    secondaryColor, lightSecondaryColor
                )
            ),
            shape = RoundedCornerShape(16 .dp)
        ),
        contentAlignment = Alignment.CenterStart
    ){
        Row(
            modifier = Modifier.padding(16 .dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16 .dp)
            ) {
                Box(
                    modifier = Modifier.size(55 .dp).background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                primaryColor, lightPrimaryColor
                            )
                        ),
                        shape = CircleShape
                    ),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(Res.drawable.course),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Column {
                    Text(
                        text = stringResource(Res.string.active_courses),
                        color = Color.White,
                        fontSize = 14 .sp
                    )
                    Text(
                        text = courses.size.toString(),
                        color = Color.White,
                        fontSize = 26 .sp
                    )
                }
            }
            Button(
                onClick = {
                    showDialog= true
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryColor,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(16 .dp),
                contentPadding = PaddingValues(horizontal = 16 .dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16 .dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.add),
                        contentDescription = null
                    )
                    Text(
                        text = stringResource(Res.string.add_course)
                    )
                }
            }
        }
        if (showDialog){
            Dialog(
                onDismissRequest = {showDialog=false}
            ){
                Card(
                    modifier = Modifier.fillMaxWidth().padding(16 .dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(16 .dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = stringResource(Res.string.add_course),
                            fontSize = 22 .sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(16 .dp)
                        )
                        LazyColumn {
                            item {
                                AddCourse()
                            }
                        }
                    }
                }
            }
        }
    }

}
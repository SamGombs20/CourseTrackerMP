package org.work.project.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.arrow_down
import coursetrackermp.composeapp.generated.resources.book
import coursetrackermp.composeapp.generated.resources.completed
import coursetrackermp.composeapp.generated.resources.my_courses
import coursetrackermp.composeapp.generated.resources.pending
import coursetrackermp.composeapp.generated.resources.progress
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.work.project.model.Category

@Composable
fun MainHeader(){
    var selectedOption by remember{ mutableStateOf(Category(Res.drawable.book, "All")) }
    val selectionOptions = listOf<Category>(
        Category(
            Res.drawable.pending, "Not Started"
        ),
        Category(
            Res.drawable.progress, "In Progress"
        ),
        Category(
            Res.drawable.completed, "Completed"
        ),

    )
    var isExpanded by remember { mutableStateOf(false) }
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(Res.string.my_courses),
            fontSize = 28 .sp,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            modifier = Modifier.shadow(
                8 .dp,
                RoundedCornerShape(24 .dp)
            ).background(Color.White),
            horizontalArrangement = Arrangement.spacedBy(8 .dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(selectedOption.icon),
                contentDescription = null,
                modifier = Modifier.padding(start = 16 .dp).size(18 .dp)
            )
            Spacer(Modifier.width(8 .dp))
            Text(
                text = selectedOption.name
            )
            IconButton(
                onClick = {
                    isExpanded = !isExpanded
                },

            ){
                Icon(
                    painter = painterResource(Res.drawable.arrow_down),
                    contentDescription = null,
                    modifier = Modifier.size(18 .dp)
                )
            }
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = {isExpanded= !isExpanded}
            ){
                selectionOptions.forEach { option->
                    DropdownMenuItem(
                        text = {Text(option.name)},
                        onClick = {
                            selectedOption= option
                        },
                        leadingIcon = {
                            Icon(
                                painter = painterResource(option.icon),
                                contentDescription = option.name
                            )
                        }
                    )
                }
            }
        }
    }
}
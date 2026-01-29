package org.work.project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.work.project.presentation.ui.secondaryColor

@Composable
fun CustomTextField(
    isError: Boolean =false,
    value: String,
    onChange:(String)-> Unit,
    label: String,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null
){
    Column {
        OutlinedTextField(
            modifier =modifier,
            value = value,
            label ={Text(label)},
            textStyle = TextStyle(
                fontSize = 14 .sp
            ),
            isError = isError,
            readOnly = readOnly,
            onValueChange = onChange,
            shape = RoundedCornerShape(16 .dp),
            trailingIcon = trailingIcon
        )
    }
}
@Composable
fun ErrorText(error: String){
    Box(
        modifier = Modifier.padding(start = 4 .dp, top = 4 .dp),
        contentAlignment = Alignment.CenterStart
    ){
        Text(
            text = error,
            color = MaterialTheme.colorScheme.error,
            fontSize = 10 .sp
        )
    }
}
@Composable
fun DetailsTitle(title: String){
    Text(
        text = title,
        fontSize = 16 .sp,
        fontWeight = FontWeight(500),
        style = TextStyle(
            textDecoration = TextDecoration.Underline
        ),
        modifier = Modifier.padding(top = 8 .dp, bottom = 4 .dp),
        color = secondaryColor
    )
}
@Composable
fun DetailsText(details: String){
    Text(
        text = details,
        fontSize = 13 .sp,
    )
}
@Composable
fun TitleWithIcon(title: String, icon: DrawableResource){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16 .dp)
    ){
        Text(
            text = title,
            fontSize = 18 .sp,
            fontWeight = FontWeight(600)
        )
        Icon(
            painter = painterResource(icon),
            contentDescription = title,
            tint = secondaryColor,

        )
    }
}
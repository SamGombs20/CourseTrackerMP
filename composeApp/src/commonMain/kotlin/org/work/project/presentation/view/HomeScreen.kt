package org.work.project.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.work.project.presentation.components.Banner
import org.work.project.presentation.components.CourseList
import org.work.project.presentation.components.MainHeader
import org.work.project.presentation.ui.primaryColor


@Composable
fun HomeScreen(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(16 .dp).verticalScroll(scrollState)
    ) {
        Banner()
        Spacer(Modifier.height(16 .dp))
        MainHeader()
        Spacer(Modifier.height(24 .dp))
        HorizontalDivider(color = primaryColor)
        Spacer(Modifier.height(8 .dp))
        CourseList()
    }
}
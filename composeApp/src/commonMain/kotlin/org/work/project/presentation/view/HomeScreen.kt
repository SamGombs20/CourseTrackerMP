package org.work.project.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.work.project.presentation.components.Banner
import org.work.project.presentation.components.MainHeader


@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.padding(16 .dp)
    ) {
        Banner()
        Spacer(Modifier.height(16 .dp))
        MainHeader()
    }
}
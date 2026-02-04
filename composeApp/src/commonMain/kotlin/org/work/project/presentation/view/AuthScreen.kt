package org.work.project.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coursetrackermp.composeapp.generated.resources.Res
import coursetrackermp.composeapp.generated.resources.courseTracker
import coursetrackermp.composeapp.generated.resources.welcome
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.work.project.presentation.ui.primaryColor
import org.work.project.presentation.ui.secondaryColor
import org.work.project.presentation.viewmodel.AuthViewModel

@Composable
fun AuthScreen(navController: NavController, authViewModel: AuthViewModel){
    var isSignUp by remember { mutableStateOf(false) }
    LaunchedEffect(Unit){
        authViewModel.getMessage()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.courseTracker),
                contentDescription = stringResource(Res.string.welcome),
                modifier = Modifier.size(48 .dp)
            )
            Row {
                Text(
                    text = "Course",
                    color = primaryColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18 .sp
                )
                Text(
                    text = "Tracker",
                    color = secondaryColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18 .sp
                )
            }
        }
        Spacer(Modifier.height(16 .dp))
        Column(
            modifier = Modifier.size(350 .dp, 450 .dp)
                .shadow(
                    10 .dp,
                    shape = RoundedCornerShape(8.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(8 .dp)
                ),

        ) {
            if (isSignUp){
                RegisterScreen(navController) {
                    isSignUp =it
                }
            }
            else{
                LogInScreen(navController, {
                    isSignUp = it
                }, authViewModel)
            }
        }
    }
}
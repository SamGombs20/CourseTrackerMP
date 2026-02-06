package org.work.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel
import org.work.project.model.user.AuthState
import org.work.project.presentation.view.AuthScreen
import org.work.project.presentation.view.MainScreen
import org.work.project.presentation.viewmodel.AuthViewModel
import org.work.project.presentation.viewmodel.CourseViewModel


@Composable
fun RootNavigation(){
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = koinViewModel()
    val courseViewModel: CourseViewModel = koinViewModel()
    val authState  by authViewModel.authState.collectAsStateWithLifecycle()
    LaunchedEffect(authState){
        when(authState){
            is AuthState.Authenticated -> {
                delay(1000)
                courseViewModel.getCourses()
                navController.navigate(Screen.Main.route){
                    popUpTo(0){
                        inclusive=true
                    }
                }
            }
            is AuthState.Error -> {}
            AuthState.Loading -> {}
            AuthState.Unauthenticated -> {
                navController.navigate(Screen.Login.route){
                    popUpTo(0){
                        inclusive = true
                    }
                }
            }
        }
    }
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route) {
            AuthScreen( authViewModel)
        }
//        composable(Screen.Register.route) {
//            RegisterScreen {
//                navController.navigate(Screen.Login.route)
//            }
//        }
        composable(Screen.Main.route) {
            MainScreen(authViewModel, courseViewModel)
        }
    }
}
package org.work.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.viewmodel.koinViewModel
import org.work.project.presentation.view.AuthScreen
import org.work.project.presentation.view.MainScreen
import org.work.project.presentation.viewmodel.AuthViewModel


@Composable
fun RootNavigation(){
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = koinViewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route) {
            AuthScreen(navController, authViewModel)
        }
//        composable(Screen.Register.route) {
//            RegisterScreen {
//                navController.navigate(Screen.Login.route)
//            }
//        }
        composable(Screen.Main.route) {
            MainScreen(navController,authViewModel)
        }
    }
}
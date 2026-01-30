package org.work.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.work.project.presentation.view.AuthScreen
import org.work.project.presentation.view.MainScreen


@Composable
fun RootNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(Screen.Login.route) {
            AuthScreen(navController)
        }
//        composable(Screen.Register.route) {
//            RegisterScreen {
//                navController.navigate(Screen.Login.route)
//            }
//        }
        composable(Screen.Main.route) {
            MainScreen()
        }
    }
}
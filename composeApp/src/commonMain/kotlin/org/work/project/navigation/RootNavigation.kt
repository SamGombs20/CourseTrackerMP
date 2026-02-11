package org.work.project.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jordond.connectivity.Connectivity
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.work.project.model.user.AuthState
import org.work.project.presentation.view.AuthScreen
import org.work.project.presentation.view.MainScreen
import org.work.project.presentation.view.NoInternetScreen
import org.work.project.presentation.view.SplashScreen
import org.work.project.presentation.viewmodel.AuthViewModel
import org.work.project.presentation.viewmodel.CourseViewModel
import org.work.project.utils.DefaultConnectivityObserver


@Composable
fun RootNavigation(){
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = koinViewModel()
    val courseViewModel: CourseViewModel = koinViewModel()
    val authState  by authViewModel.authState.collectAsStateWithLifecycle()
    val connectivity: DefaultConnectivityObserver = koinInject()

    DisposableEffect(Unit){
        connectivity.start()
        onDispose {
            connectivity.stop()
        }
    }
    val status by connectivity.status
        .collectAsStateWithLifecycle(initialValue = Connectivity.Status.Disconnected)
    LaunchedEffect(authState, status){
        when(status){
            is Connectivity.Status.Connected -> {
                when(authState){
                    is AuthState.Authenticated -> {
                        courseViewModel.getCourses()
                        navController.navigate(Screen.Main.route){
                            popUpTo(0){
                                inclusive=true
                            }
                        }
                    }
                    is AuthState.Error -> {

                    }
                    AuthState.Loading -> {}
                    AuthState.Unauthenticated -> {
                        navController.navigate(Screen.Splash.route){
                            popUpTo(0){
                                inclusive = true
                            }
                        }
                    }
                }
            }
            Connectivity.Status.Disconnected -> {
                navController.navigate(Screen.NoInternet.route)
            }

        }
    }
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Login.route) {
            AuthScreen( authViewModel)
        }
        composable(Screen.NoInternet.route) {
            NoInternetScreen()
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
package org.work.project.navigation

open class Screen(val route: String) {
    object Login: Screen("login")
    object Splash:Screen("splash")
    object Main: Screen("main")
}
package org.work.project.navigation

open class Screen(val route: String) {
    object Login: Screen("login")
    object Register:Screen("register")
    object Main: Screen("main")
}
package com.dicoding.jetskindamage.model

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object About: Screen("about")
    object Detail: Screen("home/{skinId}") {
        fun createRoute(skinId: Int) = "home/$skinId"
    }
}
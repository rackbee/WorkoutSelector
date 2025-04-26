package com.example.workoutselector

sealed class Screen (val route: String ) {
    object HomeScreen: Screen( route = "home_screen" );
}
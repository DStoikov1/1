package com.example.a1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "mainScreen"
    ) {
        composable("mainScreen") {
            MemberOfList(msg = message) {
                navController.navigate("EditingScreen")
            }
        }
        composable("EditingScreen") {
            EditingScreen()
        }
    }
}

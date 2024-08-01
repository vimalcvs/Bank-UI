package com.vimalcvs.testebud.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vimalcvs.testebud.view.BoardingOneScreen
import com.vimalcvs.testebud.view.BoardingTwoScreen
import com.vimalcvs.testebud.view.MainScreen
import com.vimalcvs.testebud.view.SplashScreens

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash", builder = {
        composable("splash") { SplashScreens(navController) }
        composable("home") { MainScreen(navController) }
        composable("boardingOne") { BoardingOneScreen(navController) }
        composable("boardingTwo") { BoardingTwoScreen(navController) }

    })
}
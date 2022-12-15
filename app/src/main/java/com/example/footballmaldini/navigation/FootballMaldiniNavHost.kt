package com.example.footballmaldini.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballmaldini.view.screens.FootballMaldiniExit
import com.example.footballmaldini.view.screens.FootballMaldiniMatch
import com.example.footballmaldini.view.screens.FootballMaldiniMenu
import com.example.footballmaldini.view.screens.FootballMaldiniOptions

@Composable
fun FootballMaldiniNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController,
        startDestination = "footballMaldiniMenu"
    ) {
        composable("footballMaldiniMenu") { FootballMaldiniMenu(navHostController) }
        composable("footballMaldiniMatch") { FootballMaldiniMatch(navHostController) }
        composable("footballMaldiniOptions") { FootballMaldiniOptions(navHostController) }
        composable("footballMaldiniExit") { FootballMaldiniExit(navHostController) }
    }
}
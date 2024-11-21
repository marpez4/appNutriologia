package com.example.appnutriologia.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnutriologia.ui.navigation.NavigationAppBar
import com.example.appnutriologia.ui.navigation.Screen
import com.example.appnutriologia.ui.navigation.TopBar
import com.example.appnutriologia.ui.screens.HomeScreen
import com.example.appnutriologia.ui.screens.MedidasScreen
import com.example.appnutriologia.ui.screens.PlanScreen

@Composable
fun MainScreen(){

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavigationAppBar(navController) },
        topBar = { TopBar(title = "Inicio") }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){ HomeScreen(innerPadding) }
            composable(Screen.Medidas.route){ MedidasScreen(innerPadding) }
            composable(Screen.Plan.route){ PlanScreen(innerPadding) }
        }
    }
}
package com.example.appnutriologia.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String, val title:String, val icon:ImageVector){
    data object Home : Screen("home", "Inicio", Icons.Default.Home)
    data object Medidas : Screen("medidas", "Medidas", Icons.Default.Done)
    data object Plan : Screen("plan", "Plan", Icons.Default.Menu)
}


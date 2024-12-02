package com.example.appnutriologia.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.appnutriologia.BuildConfig

@Composable
fun NavigationAppBar(navController: NavController){

    var selectedItem by remember { mutableStateOf(0) }

    var items =  listOf(Screen.Home.route, Screen.Medidas.route, Screen.Plan.route)

    val navColor = Color(BuildConfig.COLOR_NAV)

    NavigationBar(containerColor = navColor, contentColor = Color.White){

        items.forEachIndexed{index, item ->
            NavigationBarItem(
                onClick = {
                    navController.navigate(item){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                    selectedItem = index
                },
                label = { Text(item) },
                selected = selectedItem == index,
                icon = {
                    when(item){
                        Screen.Home.route -> Icon(Screen.Home.icon, contentDescription = Screen.Home.title)
                        Screen.Medidas.route -> Icon(Screen.Medidas.icon, contentDescription = Screen.Medidas.title)
                        Screen.Plan.route -> Icon(Screen.Plan.icon, contentDescription = Screen.Plan.title)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFFFEB3B),
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color(0xFF388E3C)
                )
            )

        }
    }
}
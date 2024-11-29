package com.example.appnutriologia.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnutriologia.R
import com.example.appnutriologia.datasources.RetrofitInstance
import com.example.appnutriologia.repositories.FoodRepository
import com.example.appnutriologia.ui.navigation.NavigationAppBar
import com.example.appnutriologia.ui.navigation.Screen
import com.example.appnutriologia.ui.navigation.TopBar
import com.example.appnutriologia.ui.screens.CategoryDetailListScreen
import com.example.appnutriologia.ui.screens.CategoryListScreen
import com.example.appnutriologia.ui.screens.HomeScreen
import com.example.appnutriologia.ui.screens.MedidasScreen
import com.example.appnutriologia.ui.screens.PlanScreen
import com.example.appnutriologia.ui.viewmodels.CategoryFoodModel

@Composable
fun MainScreen(){

    val api = RetrofitInstance.api
    val foodRepository = FoodRepository(api)
    val foodViewModel = CategoryFoodModel(foodRepository)

    val navController = rememberNavController()
    Scaffold(
        bottomBar = { NavigationAppBar(navController) },
        topBar = { TopBar(stringResource(id = R.string.inicio) ) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){ HomeScreen(navController) }
            composable(Screen.Medidas.route){ MedidasScreen() }
            composable(Screen.Plan.route){ PlanScreen(navController) }
            composable("categoryList"){ CategoryListScreen(navController, foodViewModel) }
            composable("categoryDetail/{categoryId}"){ backStackEntry ->
                val categoryId = backStackEntry.arguments?.getString("categoryId")
                CategoryDetailListScreen(categoryId, navController) }
        }
    }
}
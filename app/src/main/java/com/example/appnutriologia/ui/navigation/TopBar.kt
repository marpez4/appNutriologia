package com.example.appnutriologia.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.appnutriologia.BuildConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String){
   val navColor = Color(BuildConfig.COLOR_NAV)
   TopAppBar(
       title = { Text(title) },
     colors = topAppBarColors(
         containerColor = navColor,
         titleContentColor = Color.White
     )
   )
}

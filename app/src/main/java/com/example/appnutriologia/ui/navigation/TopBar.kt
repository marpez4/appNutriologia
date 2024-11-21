package com.example.appnutriologia.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title:String){
   TopAppBar(
       title = { Text(title) },
     colors = topAppBarColors(
         containerColor = Color(0xFF388E3C),
         titleContentColor = Color.White
     )
   )
}

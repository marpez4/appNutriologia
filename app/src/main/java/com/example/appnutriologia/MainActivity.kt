package com.example.appnutriologia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appnutriologia.ui.MainScreen
import com.example.appnutriologia.ui.theme.AppNutriologiaTheme

//val baseUrl = BuildConfig.BASE_URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNutriologiaTheme {
               MainScreen()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//        Text(text = "URL: $baseUrl")
    }
}


// Colores
//val PrimaryGreen = Color(0xFF388E3C)
//val SecondaryGreen = Color(0xFF66BB6A)
//val AccentYellow = Color(0xFFFFEB3B)
//val AccentOrange = Color(0xFFFF9800)
//val NeutralGray = Color(0xFF616161)
//val LightGray = Color(0xFFE0E0E0)
//val BackgroundWhite = Color(0xFFF4F4F4)
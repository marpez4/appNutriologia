package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appnutriologia.R

@Composable
fun HomeScreen(innerPadding: PaddingValues){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.Center
    ) {
        HomeScreenPreview()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            stringResource(id = R.string.accesos_rapidos),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LogoImage()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable {  },
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
        ){
            Box(contentAlignment = Alignment.Center){
                Text(text = "Categorías", style = MaterialTheme.typography.titleMedium)
            }
        }
    }

}

@Composable
fun LogoImage(){
    val logo: Painter = painterResource(id = R.drawable.logo1)
    Image(
        painter = logo,
        contentDescription = "Logo de la app",
        modifier = Modifier.padding(top = 8.dp)
    )
}

package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appnutriologia.R

@Composable
fun HomeScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        verticalArrangement = Arrangement.Center
    ) {
        HomeScreenPreview(navController)
    }
}

// @Preview(showBackground = true)
@Composable
fun HomeScreenPreview(navController: NavController){

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
                .clickable { navController.navigate("categoryList")},
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEB3B))
        ){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                Column(
                    modifier = Modifier.wrapContentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.category),
                        contentDescription = stringResource(id = R.string.descripcion_image),
                        modifier = Modifier
                            .size(48.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.categorias),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clickable { navController.navigate("detailCategoryList") },
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEB3B))
        ){
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                Column(
                    modifier = Modifier.wrapContentSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.grafico),
                        contentDescription = stringResource(id = R.string.avances),
                        modifier = Modifier
                            .size(48.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.avances),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

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

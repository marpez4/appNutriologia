@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appnutriologia.model.Category
import com.example.appnutriologia.ui.viewmodels.CategoryFoodModel
import com.example.appnutriologia.ui.viewmodels.CategoryUiState
import com.example.appnutriologia.R


@Composable
fun CategoryListScreen(navController: NavController, categoryFoodModel: CategoryFoodModel) {

    val uiState by categoryFoodModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.list_categorias),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        HorizontalDivider(thickness = 2.dp)

        Box(modifier = Modifier
            .fillMaxSize()
            .padding()){
            when(uiState){
                is CategoryUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is CategoryUiState.Success -> {
                    val categories = (uiState as CategoryUiState.Success).categories
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(categories){ category ->
                            CategoryItem(category, navController)
                        }
                    }
                }
                is CategoryUiState.Error -> {
                    val message = (uiState as CategoryUiState.Error).message
                    Text(
                        text = message,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

    }


}

@Composable
fun CategoryItem(category: Category, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate("categoryDetail/${category.strCategory}") }
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF66BB6A)
        )

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            category.strCategoryThumb.let { thumbUrl ->
                AsyncImage(
                    model = thumbUrl,
                    contentDescription = category.strCategory,
                    modifier = Modifier.size(64.dp)
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = category.strCategory,
                    style = TextStyle(fontSize = 24.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))

            }
        }
    }
}
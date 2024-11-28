package com.example.appnutriologia.ui.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.appnutriologia.R
import com.example.appnutriologia.model.Meal
import com.example.appnutriologia.ui.viewmodels.CategoryDetailFoodModel
import com.example.appnutriologia.ui.viewmodels.CategoryDetailUiState
import com.example.appnutriologia.ui.viewmodels.CategoryUiState

@Composable
fun CategoryDetailListScreen(
    categoryId: String?,
    navController: NavController,
    categoryDetailFoodModel: CategoryDetailFoodModel = viewModel()
) {
    val uiState by categoryDetailFoodModel.uiState.collectAsState()

    LaunchedEffect(categoryId) {
        if (categoryId != null) {
            categoryDetailFoodModel.fetchDetailCategory(categoryId)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row for placing the back icon and title on the same line
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.atras)
                )
            }
            Text(
                text = "${stringResource(id = R.string.alimentos)} $categoryId",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 8.dp)  // Space between the icon and the text
            )
        }
        HorizontalDivider(thickness = 2.dp)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {
            when (uiState) {
                is CategoryDetailUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is CategoryDetailUiState.Success -> {
                    val list = (uiState as CategoryDetailUiState.Success).detailCategories
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(list) { item ->
                            CategoryDetailItem(item)
                        }
                    }
                }
                is CategoryDetailUiState.Error -> {
                    val message = (uiState as CategoryDetailUiState.Error).message
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


// @Preview(showBackground = true)
@Composable
fun CategoryDetailItem(detailCategory: Meal){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF66BB6A)
        )

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            detailCategory.strMealThumb.let { thumbUrl ->
                AsyncImage(
                    model = thumbUrl,
                    contentDescription = detailCategory.strMeal,
                    modifier = Modifier.size(64.dp)
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = detailCategory.strMeal,
                    style = TextStyle(fontSize = 24.sp)
                )
                Spacer(modifier = Modifier.height(4.dp))

            }
        }
    }
}




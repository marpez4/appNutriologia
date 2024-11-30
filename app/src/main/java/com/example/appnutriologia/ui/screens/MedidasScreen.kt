package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appnutriologia.R
import com.example.appnutriologia.model.MedidaItem
import com.example.appnutriologia.ui.viewmodels.MedidaViewModel

@Composable
fun MedidasScreen(viewModel: MedidaViewModel = viewModel()) {

    var showDialog by remember { mutableStateOf(false) }
    val medidas by viewModel.medidas.collectAsState(initial = emptyList())

    Scaffold(
        bottomBar = {

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = stringResource(id = R.string.agregar))
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .padding(bottom = paddingValues.calculateBottomPadding()), // Ajusta el padding para el BottomNavigation
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.medidas),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                HorizontalDivider(thickness = 2.dp)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(medidas) { medida ->
                        MedidasItem(medida)
                    }
                }
            }
        }
    )

    if (showDialog) {
        AddMedidaDialog(
            onAddMedida = { newMedida ->
                viewModel.insertMedida(newMedida)
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
    }
}

// @Preview(showBackground = true)
@Composable
fun MedidasItem(medidaItem: MedidaItem){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Fecha: ${medidaItem.date}")
            Text(text = "Peso: ${medidaItem.weight}  kg")
            if(!medidaItem.notes.isNullOrEmpty()){
                Text(text = "Notas: ${medidaItem.notes}")
            }
        }
    }
}
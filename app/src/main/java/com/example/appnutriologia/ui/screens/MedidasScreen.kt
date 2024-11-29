package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.appnutriologia.R

@Composable
fun MedidasScreen(){

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
        MedidasItem()
    }
    if(showDialog){
        AddMedidaDialog(
            onAddMedida = {newMedida ->
                showDialog = false
            },
            onDismiss = {showDialog = false}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MedidasItem(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ){
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Fecha:")
            Text(text = "Peso: kg")
        }
    }
}
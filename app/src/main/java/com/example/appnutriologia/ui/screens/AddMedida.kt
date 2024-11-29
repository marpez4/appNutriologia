package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.appnutriologia.model.MedidaItem

@Composable
fun AddMedidaDialog(
    onAddMedida: (MedidaItem) -> Unit,
    onDismiss: () -> Unit) {
    var medida by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Add Country") },
        text = {
            Column {
                TextField(value = medida, onValueChange = { medida = it }, label = { Text("Country Name") })
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (medida.isNotEmpty()) {
                        val newMedida = MedidaItem(
                            weight = medida,
                            date = "",
                            notes = ""
                        )
                        // countryViewModel.addCountry(newCountry)
                        onAddMedida(newMedida)
                        onDismiss()
                    }
                    onDismiss()
                }
            ) {
                Text("Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
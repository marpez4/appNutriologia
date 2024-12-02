package com.example.appnutriologia.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.appnutriologia.R
import com.example.appnutriologia.model.MedidaItem

@Composable
fun AddMedidaDialog(
    onAddMedida: (MedidaItem) -> Unit,
    onDismiss: () -> Unit)
{
    var medida by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(id = R.string.agregarMed)) },
        text = {
            Column {
                TextField(
                    value = medida,
                    onValueChange = { medida = it },
                    label = { Text(stringResource(id = R.string.peso)) }
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text(stringResource(id = R.string.notes)) }
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (medida.isNotEmpty()) {
                        val newMedida = MedidaItem(
                            weight = medida,
                            date = getCurrentDate(),
                            notes = if (notes.isNotEmpty()) notes else null
                        )
                        onAddMedida(newMedida)
                        onDismiss()
                    }
                    onDismiss()
                }
            ) {
                Text(stringResource(id = R.string.agregar))
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text(stringResource(id = R.string.cancelar))
            }
        }
    )
}

fun getCurrentDate(): String {
    val formatter = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
    return formatter.format(java.util.Date())
}
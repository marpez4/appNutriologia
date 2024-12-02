package com.example.appnutriologia.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appnutriologia.R
import com.example.appnutriologia.ui.viewmodels.MedidaViewModel
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

@Composable
fun MedidasGraphScreen(viewModel: MedidaViewModel = viewModel()){

    val medidas = viewModel.medidas.collectAsState(initial = emptyList())

    if (medidas.value.isEmpty()) {
        Text("No hay datos disponibles para mostrar el gráfico.")
    } else {
        val entries = medidas.value.mapIndexed { index, medidasItem ->
            BarEntry(index.toFloat(), medidasItem.weight.toFloat())
        }
        val barDataSet = BarDataSet(entries, "Kg")
        barDataSet.color = Color.parseColor("#FF9800")
        val barData = BarData(barDataSet)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.grafico),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            BarChartView(barData = barData)
        }
    }


}

@Composable
fun BarChartView(barData: BarData){
    Box(modifier = Modifier.fillMaxWidth()){
        AndroidView(
            factory = {context ->
                BarChart(context).apply {
                    this.data = barData
                    this.invalidate()
                    description.isEnabled = false
                    axisLeft.setDrawGridLines(false)
                    axisRight.isEnabled = false
                    xAxis.setDrawGridLines(false)
                    setFitBars(true)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
    }
}

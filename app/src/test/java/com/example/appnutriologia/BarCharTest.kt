package com.example.appnutriologia

import com.example.appnutriologia.model.MedidaItem
import com.github.mikephil.charting.data.BarEntry
import org.junit.Assert.assertEquals
import org.junit.Test

class BarCharTest{
    @Test
    fun `barDataSet contains correct entries`(){
        
        // Datos de prueba
        val medidas = listOf(
            MedidaItem(weight = "70", date = "2024-12-01"),
            MedidaItem(weight = "75", date = "2024-12-02")
        )

        val entries = medidas.mapIndexed { index, medida ->
            BarEntry(index.toFloat(), medida.weight.toFloat())
        }

        assertEquals(2, entries.size)
        assertEquals(70f, entries[0].y)
        assertEquals(75f, entries[1].y)
    }
}
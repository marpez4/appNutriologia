package com.example.appnutriologia.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medidas_table")
data class MedidaItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val weight: String,
    val date: String,
    val notes: String? = null
)
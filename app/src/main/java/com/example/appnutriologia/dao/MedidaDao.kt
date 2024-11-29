package com.example.appnutriologia.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appnutriologia.model.MedidaItem

@Dao
interface MedidaDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(medidaItem: MedidaItem)

    @Query("SELECT * FROM medidas_table")
    fun getAllMedidas() : kotlinx.coroutines.flow.Flow<List<MedidaItem>>
}
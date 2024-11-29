package com.example.appnutriologia.datasources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appnutriologia.dao.MedidaDao
import com.example.appnutriologia.model.MedidaItem

@Database(entities = [MedidaItem::class], version = 1)
abstract class MedidaDatabase : RoomDatabase(){
    abstract fun medidaDao(): MedidaDao
}
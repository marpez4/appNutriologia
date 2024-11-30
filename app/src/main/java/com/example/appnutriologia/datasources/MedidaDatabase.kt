package com.example.appnutriologia.datasources

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appnutriologia.dao.MedidaDao
import com.example.appnutriologia.model.MedidaItem

@Database(entities = [MedidaItem::class], version = 1)
abstract class MedidaDatabase : RoomDatabase(){
    abstract fun medidaDao(): MedidaDao

    companion object{
        @Volatile
        private var INSTANCE: MedidaDatabase? = null

        fun getDatabase(context: Context): MedidaDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedidaDatabase::class.java,
                    "medidas_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
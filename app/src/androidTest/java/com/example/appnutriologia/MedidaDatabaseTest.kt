package com.example.appnutriologia

import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.example.appnutriologia.dao.MedidaDao
import com.example.appnutriologia.datasources.MedidaDatabase
import org.junit.Before
import org.junit.runner.RunWith
import android.content.Context
import androidx.room.Room
import com.example.appnutriologia.model.MedidaItem
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MedidaDatabaseTest {

    private lateinit var database: MedidaDatabase
    private  lateinit var medidaDao: MedidaDao

    @Before
    fun setup(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, MedidaDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        medidaDao = database.medidaDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun testInstrumented() = runBlocking(){
        val medidaItem = MedidaItem(weight = "70", date = "2024-12-02", notes = "Hola soy un test")

        medidaDao.insert(medidaItem)
        val medidas = medidaDao.getAllMedidas().first()

        assertEquals(1, medidas.size)

        // Verificamos que los valores sean los esperados
        val retrievedItem = medidas[0]
        assertEquals("70", retrievedItem.weight)
        assertEquals("2024-12-02", retrievedItem.date)
        assertEquals("Hola soy un test", retrievedItem.notes)


    }

}
package com.example.appnutriologia.repositories

import com.example.appnutriologia.dao.MedidaDao
import com.example.appnutriologia.model.MedidaItem
import kotlinx.coroutines.flow.first

class MedidaRepository (private val medidaDao: MedidaDao){

    suspend fun getMedidas(): List<MedidaItem>{
        try {
            val medidas:MutableList<MedidaItem> = mutableListOf()
            val medidaItemList = medidaDao.getAllMedidas().first()
            medidaItemList.map{ medidaItem ->
                medidas.add(MedidaItem(
                    weight = medidaItem.weight,
                    date = medidaItem.date,
                    notes = medidaItem.notes
                ))
            }
            return medidas
        }catch (e: Exception){
            return emptyList()
        }
    }
}
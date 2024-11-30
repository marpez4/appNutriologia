package com.example.appnutriologia.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnutriologia.dao.MedidaDao
import com.example.appnutriologia.datasources.MedidaDatabase
import com.example.appnutriologia.model.MedidaItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MedidaViewModel(application: Application): AndroidViewModel(application){
    private val doa: MedidaDao = MedidaDatabase.getDatabase(application).medidaDao()

    val medidas: Flow<List<MedidaItem>> = doa.getAllMedidas().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun insertMedida(medidaItem: MedidaItem){
        viewModelScope.launch {
            doa.insert(medidaItem)
        }
    }
}
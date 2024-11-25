package com.example.appnutriologia.repositories

import com.example.appnutriologia.datasources.RetrofitInstance
import com.example.appnutriologia.model.CategoryResponse

class FoodRepository {
    private val api = RetrofitInstance.api

    suspend fun getCategories():CategoryResponse{
        val result = api.getAllCategories()
        return result
    }
}
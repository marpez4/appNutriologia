package com.example.appnutriologia.repositories

import com.example.appnutriologia.datasources.RetrofitInstance
import com.example.appnutriologia.model.CategoryResponse
import com.example.appnutriologia.model.MealResponse

class FoodRepository {
    private val api = RetrofitInstance.api

    suspend fun getCategories():CategoryResponse{
        val result = api.getAllCategories()
        return result
    }
}

class FoodDetailRepository{
    private val api = RetrofitInstance.api
    suspend fun getDetailCategories(categoryId: String): MealResponse{
        val result = api.getDetailCategory(categoryId)
        return result
    }
}
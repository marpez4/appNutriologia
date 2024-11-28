package com.example.appnutriologia.datasources
import com.example.appnutriologia.model.CategoryResponse
import com.example.appnutriologia.model.MealResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApiService {

    @GET("json/v1/1/categories.php")
    suspend fun getAllCategories():CategoryResponse

    @GET("json/v1/1/categories.php")
    suspend fun getAllCategories(
        @Query("fields") fields:String="idCategory, strCategory, strCategoryThumb, strCategoryDescription"):CategoryResponse

    @GET("json/v1/1/filter.php?")
    suspend fun getDetailCategory(
        @Query("c") categoryId: String,
        @Query("fields") fields:String="strMeal, strMealThumb, idMeal"):MealResponse
}

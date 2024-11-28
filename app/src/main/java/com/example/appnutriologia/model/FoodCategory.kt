package com.example.appnutriologia.model

data class CategoryResponse(
    val categories: List<Category>
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)

data class MealResponse(
    val meals: List<Meal>
)

data class Meal(
    val strMeal: String,
    val strMealThumb: String,
    val idMeal: String
)

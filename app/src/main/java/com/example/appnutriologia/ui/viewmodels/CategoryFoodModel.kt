package com.example.appnutriologia.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnutriologia.model.Category
import com.example.appnutriologia.model.Meal
import com.example.appnutriologia.repositories.FoodDetailRepository
import com.example.appnutriologia.repositories.FoodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class CategoryUiState {
    object Loading : CategoryUiState()
    data class Success(val categories: List<Category>) : CategoryUiState()
    data class Error(val message: String) : CategoryUiState()
}

class CategoryFoodModel(
    private val repository: FoodRepository = FoodRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Loading)
    val uiState: StateFlow<CategoryUiState> = _uiState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                _uiState.value = CategoryUiState.Loading
                val categoryResponse = repository.getCategories()
                // Extrae la lista de categorías y envíala como parte del estado
                _uiState.value = CategoryUiState.Success(categoryResponse.categories)
            } catch (e: Exception) {
                _uiState.value = CategoryUiState.Error(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            }
        }
    }
}

sealed class CategoryDetailUiState{
    object Loading: CategoryDetailUiState()
    data class Success(val detailCategories: List<Meal>) : CategoryDetailUiState()
    data class Error(val message: String) : CategoryDetailUiState()
}

class  CategoryDetailFoodModel(
    private val repository: FoodDetailRepository = FoodDetailRepository()
): ViewModel(){
    private val _uiState = MutableStateFlow<CategoryDetailUiState>(CategoryDetailUiState.Loading)
    val uiState: StateFlow<CategoryDetailUiState> = _uiState


    public fun fetchDetailCategory(categoryId: String){
        viewModelScope.launch {
            try {
                _uiState.value = CategoryDetailUiState.Loading
                val categoryDetailResponse = repository.getDetailCategories(categoryId)
                _uiState.value = CategoryDetailUiState.Success(categoryDetailResponse.meals)
            }catch (e: Error){
                _uiState.value = CategoryDetailUiState.Error(
                    e.localizedMessage ?: "An unexpected error ocurred"
                )
            }
        }
    }
}
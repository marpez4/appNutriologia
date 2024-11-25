package com.example.appnutriologia.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnutriologia.model.Category
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

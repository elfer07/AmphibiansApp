package com.example.amphibians.ui

import com.example.amphibians.model.Amphibian

sealed interface AppUiState {
    data class Success(val amphibians: List<Amphibian>): AppUiState
    object Error: AppUiState
    object Loading: AppUiState
}
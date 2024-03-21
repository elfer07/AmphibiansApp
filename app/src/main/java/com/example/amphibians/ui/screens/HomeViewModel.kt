package com.example.amphibians.ui.screens

import android.text.Spannable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibianApplication
import com.example.amphibians.data.AmphibianRepository
import com.example.amphibians.ui.AppUiState
import kotlinx.coroutines.launch

class HomeViewModel(private val amphibianRepository: AmphibianRepository): ViewModel() {

    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            runCatching {
                amphibianRepository.getAmphibians()
            }.onSuccess {
                appUiState = AppUiState.Success(it)
            }.onFailure {
                appUiState = AppUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibianApplication)
                val amphibianRepository = application.container.amphibianRepository
                HomeViewModel(amphibianRepository = amphibianRepository)
            }
        }
    }
}
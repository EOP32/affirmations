package com.daily.affirmations.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.affirmations.data.repo.LLMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    private val repository: LLMRepository
): ViewModel() {

    private val _uiState = MutableStateFlow("New")
    val uiState = _uiState.asStateFlow()

    fun sendMessage(message: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { repository.sendMessage(message) ?: "FAILED" }
        }
    }
}
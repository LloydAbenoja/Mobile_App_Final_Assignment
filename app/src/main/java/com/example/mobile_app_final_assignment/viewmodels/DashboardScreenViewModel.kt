package com.example.mobile_app_final_assignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_app_final_assignment.models.DashboardItem
import com.example.mobile_app_final_assignment.models.ApiDevRepoClass
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardScreenViewModel @Inject constructor(
    private val repository: ApiDevRepoClass
) : ViewModel() {

    private val _dashboardState = MutableStateFlow<DashboardUiState>(DashboardUiState.Loading)
    val dashboardState: StateFlow<DashboardUiState> = _dashboardState

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboardItems(keypass) // returns DashboardResponse
                _dashboardState.value = DashboardUiState.Success(response.entities, response.entityTotal)
            } catch (e: Exception) {
                _dashboardState.value = DashboardUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed class DashboardUiState {
    object Loading : DashboardUiState()
    data class Success(val items: List<DashboardItem>, val total: Int) : DashboardUiState()
    data class Error(val message: String) : DashboardUiState()
}

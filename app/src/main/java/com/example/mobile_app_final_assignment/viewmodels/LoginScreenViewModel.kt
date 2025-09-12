package com.example.mobile_app_final_assignment.viewmodel

import androidx.lifecycle.*
import com.example.mobile_app_final_assignment.models.ApiDevRepoClass
import com.example.mobile_app_final_assignment.models.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repo: ApiDevRepoClass
) : ViewModel() {

    // Backing property for login state
    private val _loginState = MutableLiveData<UiState>()
    val loginState: LiveData<UiState> get() = _loginState

    fun login(location: String, username: String, password: String) {
        _loginState.value = UiState.Loading

        viewModelScope.launch {
            try {
                val response: LoginResponse = repo.login(location, username, password)
                _loginState.value = UiState.Success(response.keypass)
            } catch (e: Exception) {
                _loginState.value = UiState.Error(e.message ?: "Login failed")
            }
        }
    }

    // Define sealed class for UI state
    sealed class UiState {
        object Loading : UiState()
        data class Success(val keypass: String) : UiState()
        data class Error(val message: String) : UiState()
    }
}
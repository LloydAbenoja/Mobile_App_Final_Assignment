package com.example.mobile_app_final_assignment.viewmodel

import androidx.lifecycle.*
import com.example.mobile_app_final_assignment.models.AddObjectRequest
import com.example.mobile_app_final_assignment.models.AddObjectResponse
import com.example.mobile_app_final_assignment.models.ApiDevRepoClass
import com.example.mobile_app_final_assignment.network.ApiDevService
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val repo: ApiDevRepoClass
) : ViewModel() {

    private val _loginState = MutableLiveData<Result<AddObjectResponse>>()
    val loginState: LiveData<Result<AddObjectResponse>> = _loginState

    fun login(location: String, username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repo.login(location, username, password)
                _loginState.value = Result.success(response)
            } catch (e: Exception) {
                _loginState.value = Result.failure(e)
            }
        }
    }
}

package com.example.mobile_app_final_assignment.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobile_app_final_assignment.models.ApiDevRepoClass
import com.example.mobile_app_final_assignment.models.ResponseItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardScreenViewModel @Inject constructor(private val repository: ApiDevRepoClass) : ViewModel() {

    val greetingText = MutableStateFlow("Hello Class")
    val apiResponseObjects = MutableStateFlow<List<ResponseItem>>(listOf())

    init {
        Log.d("MainActivity", "LoginScreenViewModel ViewModel injected ")

        viewModelScope.launch {
            val result = repository.getAllObjectsData()
            delay(1000)
            updateGreetingTextState("Api has responded with the following items")
            delay(1000)
            apiResponseObjects.value = result
        }
    }

    private fun updateGreetingTextState(value: String) {
        greetingText.value = value
    }
}
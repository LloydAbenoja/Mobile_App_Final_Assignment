package com.example.mobile_app_final_assignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mobile_app_final_assignment.models.DashboardItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _item = MutableLiveData<DashboardItem>()
    val item: LiveData<DashboardItem> = _item

    init {
        // retrieve the DashboardItem passed from navigation
        val dashboardItem: DashboardItem? = savedStateHandle.get<DashboardItem>("item")
        dashboardItem?.let {
            _item.value = it
        }
    }
}

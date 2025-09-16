package com.example.mobile_app_final_assignment.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.mobile_app_final_assignment.models.DashboardItem
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

class DetailsScreenViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `init sets DashboardItem from SavedStateHandle`() {
        val dashboardItem = DashboardItem(
            name = "Empire State Building",
            architect = "Shreve, Lamb & Harmon",
            location = "New York",
            yearCompleted = "1931",
            style = "Art Deco",
            height = 381,
            description = "Famous skyscraper"
        )

        val savedStateHandle = SavedStateHandle(mapOf("item" to dashboardItem))
        val viewModel = DetailsScreenViewModel(savedStateHandle)

        val itemValue = viewModel.item.value
        assertNotNull(itemValue)
        assertEquals("Empire State Building", itemValue?.name)
        assertEquals("Shreve, Lamb & Harmon", itemValue?.architect)
        assertEquals("New York", itemValue?.location)
        assertEquals("1931", itemValue?.yearCompleted)
        assertEquals("Art Deco", itemValue?.style)
        assertEquals(381, itemValue?.height)
        assertEquals("Famous skyscraper", itemValue?.description)
    }

    @Test
    fun `init with no item leaves LiveData null`() {
        val savedStateHandle = SavedStateHandle()
        val viewModel = DetailsScreenViewModel(savedStateHandle)
        val itemValue = viewModel.item.value
        assertEquals(null, itemValue)
    }
}

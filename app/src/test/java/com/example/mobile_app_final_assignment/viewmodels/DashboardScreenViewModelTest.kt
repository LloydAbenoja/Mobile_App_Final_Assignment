package com.example.mobile_app_final_assignment.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mobile_app_final_assignment.models.ApiDevRepoClass
import com.example.mobile_app_final_assignment.models.DashboardItem
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardScreenViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()  // Handles LiveData threading, good habit

    private lateinit var repository: ApiDevRepoClass
    private lateinit var viewModel: DashboardScreenViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        repository = mockk()
        Dispatchers.setMain(testDispatcher)
        viewModel = DashboardScreenViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadDashboard success updates state to Success`() = runTest(testDispatcher) {
        val keypass = "mock_keypass"
        val dashboardItems = listOf(
            DashboardItem("Item1", "Architect1", "Location1", "2000", "Style1", 100, "Desc1"),
            DashboardItem("Item2", "Architect2", "Location2", "2005", "Style2", 200, "Desc2")
        )
        val totalItems = dashboardItems.size

        // Mock repository response with proper type
        coEvery { repository.getDashboardItems(keypass) } returns com.example.mobile_app_final_assignment.models.DashboardResponse(
            entities = dashboardItems,
            entityTotal = totalItems
        )

        // Call ViewModel function
        viewModel.loadDashboard(keypass)
        advanceUntilIdle()

        // Verify state
        val state = viewModel.dashboardState.value
        assertTrue(state is DashboardUiState.Success)
        state as DashboardUiState.Success
        assertEquals(totalItems, state.total)
        assertEquals(dashboardItems, state.items)
    }


    @Test
    fun `loadDashboard failure updates state to Error`() = runTest(testDispatcher) {
        val keypass = "mock_keypass"
        val errorMessage = "Network failure"

        coEvery { repository.getDashboardItems(keypass) } throws RuntimeException(errorMessage)

        viewModel.loadDashboard(keypass)
        advanceUntilIdle()

        val state = viewModel.dashboardState.value
        assertTrue(state is DashboardUiState.Error)
        state as DashboardUiState.Error
        assertEquals(errorMessage, state.message)
    }
}

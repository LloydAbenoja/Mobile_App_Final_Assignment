package com.example.mobile_app_final_assignment.viewmodels

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mobile_app_final_assignment.models.ApiDevRepoClass
import com.example.mobile_app_final_assignment.models.LoginResponse
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class LoginScreenViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginScreenViewModel
    private lateinit var repository: ApiDevRepoClass
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        repository = mockk()
        Dispatchers.setMain(testDispatcher)
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0
        viewModel = LoginScreenViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun loginSuccess_updatesStateToSuccess() = runTest(testDispatcher) {
        val expectedKey = "mock_keypass"
        coEvery { repository.login(any(), any(), any()) } returns LoginResponse(expectedKey)

        viewModel.login("location", "user", "pass")
        advanceUntilIdle()

        val state = viewModel.loginState.value
        assertTrue(state is LoginScreenViewModel.UiState.Success)
        assertEquals(expectedKey, (state as LoginScreenViewModel.UiState.Success).keypass)
    }

    @Test
    fun loginFailure_updatesStateToError() = runTest(testDispatcher) {
        val errorMessage = "Invalid credentials"
        coEvery { repository.login(any(), any(), any()) } throws RuntimeException(errorMessage)

        viewModel.login("location", "user", "wrongpass")
        advanceUntilIdle()

        val state = viewModel.loginState.value
        assertTrue(state is LoginScreenViewModel.UiState.Error)
        assertEquals(errorMessage, (state as LoginScreenViewModel.UiState.Error).message)
    }
}

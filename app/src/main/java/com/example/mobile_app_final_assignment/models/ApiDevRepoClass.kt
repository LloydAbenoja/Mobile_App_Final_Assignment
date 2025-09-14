package com.example.mobile_app_final_assignment.models

import com.example.mobile_app_final_assignment.network.ApiDevService
import javax.inject.Inject

open class ApiDevRepoClass @Inject constructor(
    private val apiDevService: ApiDevService
) {
    open suspend fun login(location: String, username: String, password: String): LoginResponse {
        val request = LoginRequest(
            username = username,
            password = password
        )
        return apiDevService.login(location, request)
    }

    open suspend fun getDashboardItems(keypass: String): DashboardResponse {
        return apiDevService.getDashboardContent(keypass = keypass)
    }
    }

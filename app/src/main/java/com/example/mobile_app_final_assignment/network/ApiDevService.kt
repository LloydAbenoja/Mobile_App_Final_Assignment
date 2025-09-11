package com.example.mobile_app_final_assignment.network

import com.example.mobile_app_final_assignment.models.AddObjectRequest
import com.example.mobile_app_final_assignment.models.AddObjectResponse
import com.example.mobile_app_final_assignment.models.DashboardResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiDevService {
    // Login: /{location}/auth
    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body requestBody: AddObjectRequest
    ): AddObjectResponse

    // Dashboard: /dashboard/{keypass}
    @GET("dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): DashboardResponse
}
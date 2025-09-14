package com.example.mobile_app_final_assignment.network

import com.example.mobile_app_final_assignment.models.DashboardResponse
import com.example.mobile_app_final_assignment.models.LoginRequest
import com.example.mobile_app_final_assignment.models.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiDevService {

    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body request: LoginRequest
    ): LoginResponse

    @GET("dashboard/{keypass}")
    suspend fun getDashboardContent( // Renamed for clarity, and added keypass parameter
        @Path("keypass") keypass: String
    ): DashboardResponse // Should return a SINGLE DashboardResponse if it's one dashboard's content
}
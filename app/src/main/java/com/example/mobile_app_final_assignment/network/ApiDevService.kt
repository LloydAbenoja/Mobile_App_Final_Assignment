package com.example.mobile_app_final_assignment.network

import com.example.mobile_app_final_assignment.models.AddObjectRequest
import com.example.mobile_app_final_assignment.models.AddObjectResponse
import com.example.mobile_app_final_assignment.models.ResponseItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiDevService {
    @GET("objects")
    suspend fun getAllObjects(): List<ResponseItem>

    @GET("objects/{number}")
    suspend fun getSingleObject(@Path("number") id: Int): ResponseItem

    @POST("objects")
    suspend fun addObject(@Body requestBody: AddObjectRequest): AddObjectResponse
}
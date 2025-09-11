package com.example.mobile_app_final_assignment.models

import com.example.mobile_app_final_assignment.network.ApiDevService
import javax.inject.Inject

class ApiDevRepoClass @Inject constructor(private val apiDevService: ApiDevService) {

    suspend fun getAllObjectsData() = apiDevService.getAllObjects()

    suspend fun getSingleObject(id: Int) = apiDevService.getSingleObject(id)

    suspend fun addSingleObject(item: AddObjectRequest) = apiDevService.addObject(requestBody = item)
}
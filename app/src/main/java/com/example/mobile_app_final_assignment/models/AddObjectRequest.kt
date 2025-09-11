package com.example.mobile_app_final_assignment.models

import com.squareup.moshi.Json

data class AddObjectRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)


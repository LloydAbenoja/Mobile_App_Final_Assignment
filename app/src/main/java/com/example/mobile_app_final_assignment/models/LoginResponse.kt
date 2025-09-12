package com.example.mobile_app_final_assignment.models

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)

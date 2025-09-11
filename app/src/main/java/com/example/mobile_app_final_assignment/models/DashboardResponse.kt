package com.example.mobile_app_final_assignment.models

import com.squareup.moshi.Json

data class DashboardResponse(
    @Json(name = "entities") val entities: List<ResponseItem>,
    @Json(name = "entityTotal") val entityTotal: Int
)
package com.example.mobile_app_final_assignment.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DashboardResponse(
    @Json(name = "entities") val entities: List<DashboardItem>,
    @Json(name = "entityTotal") val entityTotal: Int
): Parcelable
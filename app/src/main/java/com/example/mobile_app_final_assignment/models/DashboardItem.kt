package com.example.mobile_app_final_assignment.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@kotlinx.parcelize.Parcelize
class DashboardItem (
    @Json(name = "property1") val property1: String?,
    @Json(name = "property2") val property2: String?,
    @Json(name = "description") val description: String
): Parcelable
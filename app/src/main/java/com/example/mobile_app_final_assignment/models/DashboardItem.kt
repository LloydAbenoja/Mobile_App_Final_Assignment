package com.example.mobile_app_final_assignment.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@kotlinx.parcelize.Parcelize
class DashboardItem (
    @Json(name = "name") val name: String?,
    @Json(name = "architect") val architect: String?,
    @Json(name = "location") val location: String?,
    @Json(name = "yearCompleted") val yearCompleted: String?,
    @Json(name = "style") val style: String?,
    @Json(name = "height") val height: Int?,
    @Json(name = "description") val description: String?
): Parcelable
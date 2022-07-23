package com.mityushovn.kodetestproject.domain.models

import com.google.gson.annotations.SerializedName

/**
 * Enum of all departments of the company
 */
enum class Department {
    ALL,

    @SerializedName("android")
    ANDROID,

    @SerializedName("ios")
    IOS,

    @SerializedName("design")
    DESIGN,

    @SerializedName("management")
    MANAGEMENT,

    @SerializedName("qa")
    QA,

    @SerializedName("back_office")
    BACK_OFFICE,

    @SerializedName("frontend")
    FRONTEND,

    @SerializedName("hr")
    HR,

    @SerializedName("pr")
    PR,

    @SerializedName("backend")
    BACKEND,

    @SerializedName("support")
    SUPPORT,

    @SerializedName("analytics")
    ANALYTICS
}
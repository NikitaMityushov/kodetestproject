package com.mityushovn.kodetestproject.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.mityushovn.kodetestproject.ui.screens.main.MainScreen

/**
 * User domain model for [MainScreen]
 */
@Parcelize
data class UserDomain(
    val id: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
    val birthdate: String,
    val phone: String,
    val userTag: String,
    val department: String,
    val position: String,
    val age: String
) : Parcelable
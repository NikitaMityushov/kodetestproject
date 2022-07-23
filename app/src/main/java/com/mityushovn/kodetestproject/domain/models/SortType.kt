package com.mityushovn.kodetestproject.domain.models

import com.mityushovn.kodetestproject.ui.screens.main.MainScreen

/**
 * This enum represent types of sorting UsersList of MainScreen.
 * @see MainScreen
 * [ABC] - sorting by alphabet.
 * [BIRTHDAY] - sorting by birthday.
 */
enum class SortType {
    ABC,
    BIRTHDAY
}
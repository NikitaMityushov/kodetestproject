package com.mityushovn.kodetestproject.ui.screens.main.viewmodel

import com.mityushovn.kodetestproject.utils.mvi_interfaces.Reducer

val MainScreenReducer: Reducer = { uiState, uiIntent ->
    uiState as MainScreenUiState
    when (uiIntent) {
        is StartLoading -> {
            MainScreenUiState()
        }
        is EndLoadingWithSuccess -> {
            MainScreenUiState()
        }
        is EndLoadingWithError -> {
            MainScreenUiState()
        }
        is InputTextChanged -> {
            uiState.copy(searchInput = uiIntent.text)
        }
        RefreshLayoutSwiped -> TODO()
        is SortTypeClicked -> TODO()
        is TabClicked -> {
            uiState
        }
        else -> {
            uiState
        }
    }
}
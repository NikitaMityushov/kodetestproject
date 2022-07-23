package com.mityushovn.kodetestproject.ui.screens.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.mityushovn.kodetestproject.utils.mvi_interfaces.Middleware
import com.mityushovn.kodetestproject.utils.mvi_interfaces.Reducer
import com.mityushovn.kodetestproject.utils.mvi_interfaces.StoreViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Represents main screen store.
 */
class MainScreenViewModel(
    initialState: MainScreenUiState = MainScreenUiState(),
    reducer: Reducer,
    middlewaresDispatcher: CoroutineDispatcher = Dispatchers.IO,
    vararg middlewares: Middleware
) : StoreViewModel<MainScreenUiState, MainScreenIntents>(
    initialState,
    reducer,
    middlewaresDispatcher,
    *middlewares
) {
    fun searchInputTextChanged(text: String) {
        viewModelScope.launch {
            currentIntent.emit(InputTextChanged(text))
        }
    }

    fun tabClicked(tabIndex: Int) {
        viewModelScope.launch {
            currentIntent.emit(TabClicked(tabIndex))
        }
    }
}
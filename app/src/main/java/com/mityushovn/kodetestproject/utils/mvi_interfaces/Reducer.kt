package com.mityushovn.kodetestproject.utils.mvi_interfaces

/**
 * Reducer in the MVI pattern.
 */
typealias Reducer = (UiState, UiIntent) -> UiState

/**
 *  Updates the state of the UI.
 */
fun reduce(
    prevState: UiState,
    intent: UiIntent,
    reducer: Reducer
): UiState =
    reducer(prevState, intent)
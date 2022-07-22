package com.mityushovn.kodetestproject.utils.mvi_interfaces

/**
 * Reducer in the MVI pattern.
 */
typealias Reducer = (UiState, Effect) -> UiState

/**
 *  Updates the state of the UI.
 */
fun reduce(
    prevState: UiState,
    effect: Effect,
    reducer: Reducer
): UiState =
    reducer(prevState, effect)
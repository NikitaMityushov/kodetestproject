package com.mityushovn.kodetestproject.utils.mvi_interfaces

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn

/**
 * Represents MVI's middleware to apply business logic.
 */
typealias Middleware = suspend (UiState, UiIntent) -> Effect

fun applyMiddleware(
    state: Flow<UiState>,
    intent: Flow<UiIntent>,
    coroutineDispatcher: CoroutineDispatcher,
    middleware: Middleware
): Flow<Effect> =
    state.combine(intent, middleware).flowOn(coroutineDispatcher)
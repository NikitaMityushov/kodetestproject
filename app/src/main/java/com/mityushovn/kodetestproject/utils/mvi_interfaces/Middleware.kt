package com.mityushovn.kodetestproject.utils.mvi_interfaces

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 * Represents MVI's middleware to apply business logic.
 */
typealias Middleware = (Flow<UiState>, Flow<UiIntent>) -> Flow<UiIntent>

fun <S : UiState, I : UiIntent> applyMiddleware(
    state: Flow<S>,
    intent: Flow<I>,
    coroutineDispatcher: CoroutineDispatcher,
    middleware: Middleware
): Flow<UiIntent> = middleware(state, intent).flowOn(coroutineDispatcher)

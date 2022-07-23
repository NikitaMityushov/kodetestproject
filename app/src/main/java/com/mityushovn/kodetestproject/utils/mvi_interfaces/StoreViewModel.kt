package com.mityushovn.kodetestproject.utils.mvi_interfaces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * ViewModel implementation of MVI Store with [currentState] public observable property.
 * @see Reducer
 * @see Middleware
 */
abstract class StoreViewModel<S : UiState, I : UiIntent>(
    initialState: S,
    private val reducer: Reducer,
    private val middlewaresDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private vararg val middlewares: Middleware
) : ViewModel() {

    /**
     * Represents observable state for UI
     */
    var currentState: MutableStateFlow<S> = MutableStateFlow(initialState)
        private set

    /**
     * Stores current intent from UI
     */
    @Suppress("UNCHECKED_CAST")
    protected var currentIntent: MutableStateFlow<I> = MutableStateFlow(EmptyUiIntent as I)

    init {
        collectIntents()
        collectMiddlewares()
    }

    /**
     * Subscribes to all middlewares passed to constructor.
     */
    @Suppress("UNCHECKED_CAST")
    protected fun collectMiddlewares() {
        viewModelScope.launch {
            middlewares.forEach { middleware ->
                applyMiddleware(
                    currentState,
                    currentIntent,
                    middlewaresDispatcher,
                    middleware
                ).collect { effect ->
                    currentIntent.emit(effect as I)
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    protected fun collectIntents() {
        viewModelScope.launch {
            currentIntent.combine(currentState) { uiIntent: UiIntent, prevState: UiState ->
                reduce(prevState, uiIntent, reducer)
            }
                .distinctUntilChanged()
                .collect { newState -> currentState.emit(newState as S) }
        }
    }
}
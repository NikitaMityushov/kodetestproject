package com.mityushovn.kodetestproject.utils.mvi_interfaces

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel implementation of MVI's Store with [currentState] public observable property.
 * @see Reducer
 * @see Middleware
 */
abstract class StoreViewModel(
    initialState: UiState,
    private vararg val middlewares: Middleware,
    private val reducer: Reducer,
    private val middlewaresDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    /**
     * Represents observable state for UI
     */
    var currentState: MutableStateFlow<UiState> = MutableStateFlow(initialState)
        private set

    /**
     * Stores current intent from UI
     */
    protected var currentIntent: MutableStateFlow<UiIntent> = MutableStateFlow(EmptyUiIntent)

    init {
        collectMiddlewares()
    }

    /**
     * Subscribes to all middlewares passed to constructor.
     */
    protected fun collectMiddlewares() {
        viewModelScope.launch {
            middlewares.forEach { middleware ->
                applyMiddleware(
                    currentState,
                    currentIntent,
                    middlewaresDispatcher,
                    middleware
                ).collect { effect ->
                    val newUiState = reduce(currentState.value, effect, reducer)
                    currentState.emit(newUiState)
                }
            }
        }
    }
}
package com.mityushovn.kodetestproject.ui.screens.main.viewmodel

import com.mityushovn.kodetestproject.utils.mvi_interfaces.EmptyUiIntent
import com.mityushovn.kodetestproject.utils.mvi_interfaces.Middleware
import com.mityushovn.kodetestproject.utils.mvi_interfaces.UiIntent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

private const val DEBOUNCE_TIMEOUT = 500L

/**
 * This middleware is used to debounce [InputTextChanged] UI intents.
 */
@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
val inputTextChangedMiddleware: Middleware = { _, intent ->
    intent
        .filter { it is InputTextChanged }
        .map {
            it as InputTextChanged
        }
        .onEach {
            println("filter $it")
        }
        .debounce(DEBOUNCE_TIMEOUT)
        .onEach {
            println("after debounce $it")
        }
        .flatMapLatest {
            flow<UiIntent> {
                delay(600)
                emit(EmptyUiIntent)
            }
        }
        .onEach {
            println("after flatMapLatest $it")
        }
        .catch { emit(EndLoadingWithError(it)) }
        .onStart { emit(StartLoading) }
}
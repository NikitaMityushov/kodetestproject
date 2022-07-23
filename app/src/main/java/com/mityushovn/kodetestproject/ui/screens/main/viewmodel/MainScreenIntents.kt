package com.mityushovn.kodetestproject.ui.screens.main.viewmodel

import com.mityushovn.kodetestproject.domain.models.SortType
import com.mityushovn.kodetestproject.domain.models.UserDomain
import com.mityushovn.kodetestproject.utils.mvi_interfaces.UiIntent
import com.mityushovn.kodetestproject.ui.screens.main.MainScreen

/**
 * [MainScreen] ui intents.
 */
sealed class MainScreenIntents : UiIntent
data class TabClicked(val tabIndex: Int) : MainScreenIntents()
object RefreshLayoutSwiped : MainScreenIntents()
data class InputTextChanged(val text: String) : MainScreenIntents()
data class SortTypeClicked(val sortType: SortType) : MainScreenIntents()

// effects
object StartLoading : MainScreenIntents()
data class EndLoadingWithSuccess(val data: List<UserDomain>) : MainScreenIntents()
data class EndLoadingWithError(val error: Throwable) : MainScreenIntents()

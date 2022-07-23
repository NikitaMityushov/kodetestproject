package com.mityushovn.kodetestproject.ui.screens.main.viewmodel

import com.mityushovn.kodetestproject.domain.models.Department
import com.mityushovn.kodetestproject.domain.models.SortType
import com.mityushovn.kodetestproject.domain.models.UserDomain
import com.mityushovn.kodetestproject.ui.screens.main.MainScreen
import com.mityushovn.kodetestproject.utils.mvi_interfaces.UiState

/**
 * The class describes the configuration of the MainScreen at a given time.
 * @see MainScreen
 */
data class MainScreenUiState(
    val isError: Boolean = false,

    val initialUsersList: List<UserDomain> = emptyList(),
    val filteredByTabUsersList: List<UserDomain> = initialUsersList,
    val usersListToShow: List<UserDomain> = filteredByTabUsersList,
    val sortedBy: SortType = SortType.ABC,

    val isLoading: Boolean = false,
    val searchInput: String = "",

    val tabs: Set<String> = departments,
    val selectedTabIndex: Int = 0
) : UiState

/**
 * Constants for ScrollableTabs titles
 */
private val departments =
    setOf(
        Department.ALL.name,
        Department.ANDROID.name,
        Department.IOS.name,
        Department.DESIGN.name,
        Department.MANAGEMENT.name,
        Department.QA.name,
        Department.BACK_OFFICE.name,
        Department.FRONTEND.name,
        Department.HR.name,
        Department.PR.name,
        Department.BACKEND.name,
        Department.SUPPORT.name,
        Department.ANALYTICS.name
    )
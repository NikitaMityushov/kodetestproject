package com.mityushovn.kodetestproject.ui.screens.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mityushovn.kodetestproject.ui.screens.main.searchbar.SearchBar
import com.mityushovn.kodetestproject.ui.screens.main.tabs.Tabs
import com.mityushovn.kodetestproject.ui.screens.main.userslist.RefreshingUsersList
import com.mityushovn.kodetestproject.ui.screens.main.viewmodel.MainScreenReducer
import com.mityushovn.kodetestproject.ui.screens.main.viewmodel.MainScreenUiState
import com.mityushovn.kodetestproject.ui.screens.main.viewmodel.MainScreenViewModel
import com.mityushovn.kodetestproject.ui.screens.main.viewmodel.inputTextChangedMiddleware
import com.mityushovn.kodetestproject.ui.theme.KodeTheme
import kotlinx.coroutines.Dispatchers

/**
 * Main screen of the app.
 * Contains [SearchBar], [Tabs] and [RefreshingUsersList] components.
 */
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel
) {
    val uiState by viewModel.currentState.collectAsState()

    Surface(modifier = modifier) {
        Column() {
            SearchBar(
                inputText = uiState.searchInput,
                onValueChanged = { viewModel.searchInputTextChanged(it) },
                onClickTrailingIcon = { /*TODO*/ })
            Tabs(
                tabs = uiState.tabs,
                selectedTabIndex = uiState.selectedTabIndex,
                onTabClicked = { viewModel.tabClicked(it) }
            )
//            RefreshingUsersList()
        }
    }
}

/**
 * Preview of the [MainScreen] component.
 */
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    showSystemUi = true
)
@Preview(
    name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewMainScreen() {
    val viewModel = MainScreenViewModel(
        initialState = MainScreenUiState(),
        reducer = MainScreenReducer,
        middlewaresDispatcher = Dispatchers.IO,
        inputTextChangedMiddleware
    )
    KodeTheme {
        MainScreen(viewModel = viewModel)
    }
}
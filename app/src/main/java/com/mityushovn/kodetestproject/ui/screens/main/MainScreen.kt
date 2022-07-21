package com.mityushovn.kodetestproject.ui.screens.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mityushovn.kodetestproject.ui.screens.main.searchbar.SearchBar
import com.mityushovn.kodetestproject.ui.screens.main.tabs.Tabs
import com.mityushovn.kodetestproject.ui.screens.main.userslist.RefreshingUsersList
import com.mityushovn.kodetestproject.ui.theme.KodeTheme

/**
 * Main screen of the app.
 * Contains [SearchBar], [Tabs] and [RefreshingUsersList] components.
 */
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier) {
        Column() {
            SearchBar(onValueChanged = { /*TODO*/ }, onClickTrailingIcon = { /*TODO*/ })
//            Tabs()
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
    KodeTheme {
        MainScreen()
    }
}
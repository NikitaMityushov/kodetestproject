package com.mityushovn.kodetestproject.ui.screens.main.tabs

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.kodetestproject.ui.theme.KodeTheme

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    tabs: Set<String>,
    selectedTabIndex: Int,
    onTabClicked: (Int) -> Unit
) {
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        contentColor = KodeTheme.colors.backgroundPrimary,
        backgroundColor = KodeTheme.colors.backgroundPrimary,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(currentTabPosition = tabPositions[selectedTabIndex]),
                color = KodeTheme.colors.contentActivePrimary
            )
        },
        modifier = Modifier.wrapContentWidth(),
        edgePadding = 0.dp,
        tabs = {
            tabs.forEachIndexed { tabIndex, tabTitle ->
                Tab(
                    selected = selectedTabIndex == tabIndex,
                    onClick = { onTabClicked(tabIndex) },
                    modifier = modifier.wrapContentWidth(),
                    selectedContentColor = KodeTheme.colors.textPrimary,
                    unselectedContentColor = KodeTheme.colors.textTertiary
                ) {
                    Text(
                        text = tabTitle,
                        style = KodeTheme.typography.textMedium,
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                bottom = 8.dp,
                                start = 12.dp,
                                end = 12.dp
                            )
                    )
                }
            }
        }
    )
}

/**
 * Preview night and day modes
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
fun PreviewTabs(
) {
    KodeTheme {

        val tabs = setOf("Design", "Android", "iOS", "Support", "Managers")
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }
        val onTabClicked: (Int) -> Unit = {
            selectedTabIndex = it
        }

        Surface(modifier = Modifier.padding(16.dp)) {
            Column {
                Tabs(
                    modifier = Modifier.wrapContentWidth(),
                    tabs = tabs,
                    selectedTabIndex = selectedTabIndex,
                    onTabClicked = onTabClicked
                )
            }
        }
    }
}
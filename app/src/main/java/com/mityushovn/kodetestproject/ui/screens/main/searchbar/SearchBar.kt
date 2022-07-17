package com.mityushovn.kodetestproject.ui.screens.main.searchbar

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.kodetestproject.R
import com.mityushovn.kodetestproject.ui.components.BaseSearchBar
import com.mityushovn.kodetestproject.ui.theme.KodeTheme

private const val EMPTY_STRING = ""

/**
 * Search bar implementation for the Main Screen composable function.
 */
@Composable
fun SearchBar(
    inputText: String = EMPTY_STRING,
    onValueChanged: (String) -> Unit,
    onClickTrailingIcon: () -> Unit,
    paintTrailingIconTrigger: Boolean = false,
) {

    val backgroundColor = KodeTheme.colors.backgroundSecondary
    // icons
    val leadingIcon = painterResource(R.drawable.search)
    val leadingIconNoFocusColor = KodeTheme.colors.contentDefaultSecondary
    val leadingIconOnFocusColor = KodeTheme.colors.contentActiveSecondary

    val trailingIconMenu = painterResource(id = R.drawable.menu)
    val trailingIconNoTriggerColor = KodeTheme.colors.contentDefaultPrimary
    val trailingIconOnTriggerColor = KodeTheme.colors.contentActivePrimary
    val trailingIconCancel = painterResource(R.drawable.cancelicon)
    // string resources
    val textPlaceholder = stringResource(id = R.string.search_placeholder)
    val textPlaceholderTextStyle = KodeTheme.typography.textMedium
    val textPlaceholderColor = KodeTheme.colors.contentDefaultSecondary

    val cancelStr = stringResource(R.string.cancel)
    val cancelStrTextStyle = KodeTheme.typography.subheadSemiBold
    val cancelStrColor = KodeTheme.colors.contentActivePrimary

    val inputTextStyle = KodeTheme.typography.textMedium
    val inputTextColor = KodeTheme.colors.contentActiveSecondary


    BaseSearchBar(
        inputText = inputText,
        onValueChanged = onValueChanged,
        onClickTrailingIcon = onClickTrailingIcon,
        backgroundColor = backgroundColor,
        textPlaceholder = textPlaceholder,
        textPlaceholderTextStyle = textPlaceholderTextStyle,
        textPlaceholderColor = textPlaceholderColor,
        cancelStr = cancelStr,
        cancelStrTextStyle = cancelStrTextStyle,
        cancelStrColor = cancelStrColor,
        leadingIcon = leadingIcon,
        leadingIconOnFocusColor = leadingIconOnFocusColor,
        leadingIconNoFocusColor = leadingIconNoFocusColor,
        trailingIconMenu = trailingIconMenu,
        trailingIconOnTriggerColor = trailingIconOnTriggerColor,
        trailingIconNoTriggerColor = trailingIconNoTriggerColor,
        paintTrailingIconTrigger = paintTrailingIconTrigger,
        trailingIconCancel = trailingIconCancel,
        inputTextStyle = inputTextStyle,
        inputTextColor = inputTextColor
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
fun PreviewSearchBar(
) {
    KodeTheme {
        Surface(modifier = Modifier.padding(16.dp)) {
            val onClickTrailingButton: () -> Unit = { }
            val inputText = remember {
                mutableStateOf(EMPTY_STRING)
            }
            val onValueChanged: (String) -> Unit = { inputText.value = it }

            Column {
                SearchBar(
                    onValueChanged = onValueChanged,
                    inputText = inputText.value,
                    onClickTrailingIcon = onClickTrailingButton,
                    paintTrailingIconTrigger = true
                )
                SearchBar(
                    onValueChanged = onValueChanged,
                    inputText = inputText.value,
                    onClickTrailingIcon = onClickTrailingButton
                )
            }

        }
    }

}
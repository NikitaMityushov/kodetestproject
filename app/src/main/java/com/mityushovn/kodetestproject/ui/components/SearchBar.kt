package com.mityushovn.kodetestproject.ui.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.kodetestproject.R
import com.mityushovn.kodetestproject.ui.theme.*

private const val EMPTY_STRING = ""

/**
 * Search bar implementation for the Main Screen composable function.
 */
@Composable
fun MainScreenSearchBar(
    inputText: String = EMPTY_STRING,
    onValueChanged: (String) -> Unit,
    onClickTrailingIcon: () -> Unit,
    paintTrailingIconTrigger: Boolean = false,
) {

    val backgroundColor = MaterialTheme.colors.surface
    // icons
    val leadingIcon = painterResource(R.drawable.search)
    val leadingIconNoFocusColor = MaterialTheme.colors.onSurface
    val leadingIconOnFocusColor = MaterialTheme.colors.onPrimary

    val trailingIconMenu = painterResource(id = R.drawable.menu)
    val trailingIconNoTriggerColor = MaterialTheme.colors.onSurface
    val trailingIconOnTriggerColor = MaterialTheme.colors.secondary
    val trailingIconCancel = painterResource(R.drawable.cancelicon)
    // string resources
    val textPlaceholder = stringResource(id = R.string.search_placeholder)
    val cancelStr = stringResource(R.string.cancel)
    // text styles
    val textPlaceholderTextStyle = Text1Medium
    val cancelStrTextStyle = SubheadSemibold
    val inputTextStyle = Text3Medium

    BaseSearchBar(
        inputText = inputText,
        onValueChanged = onValueChanged,
        onClickTrailingIcon = onClickTrailingIcon,
        backgroundColor = backgroundColor,
        textPlaceholder = textPlaceholder,
        textPlaceholderTextStyle = textPlaceholderTextStyle,
        cancelStr = cancelStr,
        cancelStrTextStyle = cancelStrTextStyle,
        leadingIcon = leadingIcon,
        leadingIconOnFocusColor = leadingIconOnFocusColor,
        leadingIconNoFocusColor = leadingIconNoFocusColor,
        trailingIconMenu = trailingIconMenu,
        trailingIconOnTriggerColor = trailingIconOnTriggerColor,
        trailingIconNoTriggerColor = trailingIconNoTriggerColor,
        paintTrailingIconTrigger = paintTrailingIconTrigger,
        trailingIconCancel = trailingIconCancel,
        inputTextStyle = inputTextStyle
    )
}

/**
 * Base search bar
 */
@Composable
fun BaseSearchBar(
    modifier: Modifier = Modifier,
    inputText: String,
    inputTextStyle: TextStyle,
    onValueChanged: (String) -> Unit,
    onClickTrailingIcon: () -> Unit,
    backgroundColor: Color,
    // placeholder
    textPlaceholder: String,
    textPlaceholderTextStyle: TextStyle,
    // cancel string
    cancelStr: String,
    cancelStrTextStyle: TextStyle,
    // leading icon
    leadingIcon: Painter,
    leadingIconNoFocusColor: Color,
    leadingIconOnFocusColor: Color,
    // trailing icon menu
    trailingIconMenu: Painter,
    paintTrailingIconTrigger: Boolean = false,
    trailingIconNoTriggerColor: Color,
    trailingIconOnTriggerColor: Color = trailingIconNoTriggerColor, // default is the same as no focus
    // trailing icon cancel
    trailingIconCancel: Painter,
) {
    /*
     * if Search bar is on focus, the leading icon color changes
     */
    var paintLeadingIconTrigger by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.onFocusChanged {
            paintLeadingIconTrigger = it.isFocused
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = inputText,
            onValueChange = onValueChanged,
            singleLine = true,
            textStyle = inputTextStyle,
            leadingIcon = {
                Icon(
                    painter = leadingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = if (paintLeadingIconTrigger) leadingIconOnFocusColor else leadingIconNoFocusColor
                )
            },
            placeholder = {
                Text(
                    text = textPlaceholder,
                    style = textPlaceholderTextStyle
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = modifier
                .padding(top = 6.dp, bottom = 6.dp)
                .weight(3f),
            trailingIcon = {
                if (inputText.isEmpty()) {
                    Icon(
                        painter = trailingIconMenu,
                        contentDescription = null,
                        modifier = modifier
                            .size(height = 12.dp, width = 20.dp)
                            .clickable {
                                onClickTrailingIcon()
                            },
                        tint = if (paintTrailingIconTrigger) trailingIconOnTriggerColor else trailingIconNoTriggerColor
                    )
                } else {
                    Icon(
                        painter = trailingIconCancel,
                        contentDescription = null,
                        modifier = modifier
                            .size(height = 15.56.dp, width = 15.56.dp)
                            .clickable {
                                onValueChanged(EMPTY_STRING)
                            }
                    )
                }
            },
            shape = RoundedCornerShape(16.dp)
        )

//        val density = LocalDensity.current
        AnimatedVisibility(
            visible = inputText.isNotEmpty(),
            enter =
            expandHorizontally(
                animationSpec = spring(Spring.DampingRatioLowBouncy)
            ),
            exit = shrinkHorizontally(
                animationSpec = spring(Spring.DampingRatioMediumBouncy)
            )
        ) {

            Text(
                modifier = Modifier
                    .padding(12.dp)
                    .wrapContentWidth()
                    .clickable {
                        onValueChanged(EMPTY_STRING)
                    },
                text = cancelStr,
                style = cancelStrTextStyle
            )
        }
    }
}

/**
 * Preview night and day modes
 */
@Preview(
    name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    showSystemUi = true
)
@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PreviewSearchBar(
) {
    KodetestprojectTheme {
        Surface(modifier = Modifier.padding(16.dp)) {
            val onClickTrailingButton: () -> Unit = { }
            val inputText = remember {
                mutableStateOf(EMPTY_STRING)
            }
            val onValueChanged: (String) -> Unit = { inputText.value = it }

            Column {
                MainScreenSearchBar(
                    onValueChanged = onValueChanged,
                    inputText = inputText.value,
                    onClickTrailingIcon = onClickTrailingButton,
                    paintTrailingIconTrigger = true
                )
                MainScreenSearchBar(
                    onValueChanged = onValueChanged,
                    inputText = inputText.value,
                    onClickTrailingIcon = onClickTrailingButton
                )
            }

        }
    }

}
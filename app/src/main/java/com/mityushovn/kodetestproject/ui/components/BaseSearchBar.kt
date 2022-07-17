package com.mityushovn.kodetestproject.ui.components

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

private const val EMPTY_STRING = ""

/**
 * Base search bar.
 * Stateless composable
 */
@Composable
fun BaseSearchBar(
    modifier: Modifier = Modifier,
    inputText: String,
    inputTextStyle: TextStyle,
    inputTextColor: Color,
    onValueChanged: (String) -> Unit,
    onClickTrailingIcon: () -> Unit,
    backgroundColor: Color,
    // placeholder
    textPlaceholder: String,
    textPlaceholderTextStyle: TextStyle,
    textPlaceholderColor: Color,
    // cancel string
    cancelStr: String,
    cancelStrTextStyle: TextStyle,
    cancelStrColor: Color,
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
                    style = textPlaceholderTextStyle,
                    color = textPlaceholderColor
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = backgroundColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                textColor = inputTextColor
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
                style = cancelStrTextStyle,
                color = cancelStrColor
            )
        }
    }
}

package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

/**
 * Custom design system implementation for the project
 */

/**
 * Colors
 */
@Immutable
data class KodeColors(
    // background
    val backgroundPrimary: Color,
    val backgroundSecondary: Color,
    val background: Color,
    val backgroundTransparent: Color,
    val errorBackground: Color,
    val skeleton: List<Color> = emptyList(), // gradient background
    // content
    val contentActivePrimary: Color,
    val contentActiveSecondary: Color,
    val contentDefaultPrimary: Color,
    val contentDefaultSecondary: Color,
    // text
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textButton: Color
)

/**
 * Typography
 */
@Immutable
data class KodeTypography(
    val title1Bold: TextStyle,
    val title2SemiBold: TextStyle,
    val title3SemiBold: TextStyle,
    val title3Regular: TextStyle,
    val headlineMedium: TextStyle,
    val headlineRegular: TextStyle,
    val headlineSemiBold: TextStyle,
    val caption1Regular: TextStyle,
    val textSemiBold: TextStyle,
    val textMedium: TextStyle,
    val subheadMedium: TextStyle,
    val subheadSemiBold: TextStyle
)
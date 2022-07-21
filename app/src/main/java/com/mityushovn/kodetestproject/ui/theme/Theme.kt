package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

private val LocalKodeColors = staticCompositionLocalOf {
    KodeColors(
        backgroundPrimary = Color.Unspecified,
        backgroundSecondary = Color.Unspecified,
        background = Color.Unspecified,
        backgroundTransparent = Color.Unspecified,
        errorBackground = Color.Unspecified,
        contentActivePrimary = Color.Unspecified,
        contentActiveSecondary = Color.Unspecified,
        contentDefaultPrimary = Color.Unspecified,
        contentDefaultSecondary = Color.Unspecified,
        textPrimary = Color.Unspecified,
        textSecondary = Color.Unspecified,
        textTertiary = Color.Unspecified,
        textButton = Color.Unspecified,
        skeletonGradient0 = Color.Unspecified,
        skeletonGradient1 = Color.Unspecified,
    )
}

private val LocalKodeTypography = staticCompositionLocalOf {
    KodeTypography(
        title1Bold = TextStyle.Default,
        title2SemiBold = TextStyle.Default,
        title3SemiBold = TextStyle.Default,
        title3Regular = TextStyle.Default,
        headlineMedium = TextStyle.Default,
        headlineRegular = TextStyle.Default,
        headlineSemiBold = TextStyle.Default,
        caption1Regular = TextStyle.Default,
        textSemiBold = TextStyle.Default,
        textMedium = TextStyle.Default,
        subheadMedium = TextStyle.Default,
        subheadSemiBold = TextStyle.Default
    )
}

/**
 * Provides a set of colors and typography styles to be used in the Kode application.
 */
@Composable
fun KodeTheme(
    content: @Composable () -> Unit
) {
    val colors = kodeLightColors
    val typography = kodeTypography

    CompositionLocalProvider(
        LocalKodeColors provides colors,
        LocalKodeTypography provides typography,
        content = content
    )
}

/**
 * Contains functions to access the current theme values provided at the call site's position in the hierarchy.
 */
object KodeTheme {
    /**
     * Retrieves the current [KodeColors]
     */
    val colors: KodeColors
        @Composable
        get() = LocalKodeColors.current

    /**
     * Retrieves the current [KodeTypography]
     */
    val typography: KodeTypography
        @Composable
        get() = LocalKodeTypography.current
}

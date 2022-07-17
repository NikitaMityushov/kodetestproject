package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

val LocalKodeColors = staticCompositionLocalOf {
    KodeColors(
        background = Color.Unspecified,
        backgroundPrimary = Color.Unspecified,
        backgroundSecondary = Color.Unspecified,
        backgroundTransparent = Color.Unspecified,
        errorBackground = Color.Unspecified,
        contentActivePrimary = Color.Unspecified,
        contentDefaultSecondary = Color.Unspecified,
        contentActiveSecondary = Color.Unspecified,
        contentDefaultPrimary = Color.Unspecified,
        textButton = Color.Unspecified,
        textPrimary = Color.Unspecified,
        textSecondary = Color.Unspecified,
        textTertiary = Color.Unspecified,
    )
}

val LocalKodeTypography = staticCompositionLocalOf {
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


@Composable
fun KodeTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
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

object KodeTheme {
    val colors: KodeColors
        @Composable
        get() = LocalKodeColors.current
    val typography: KodeTypography
        @Composable
        get() = LocalKodeTypography.current
}

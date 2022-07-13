package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.ui.graphics.Color

private val PrimaryViolet = Color(0xFF6534FF)
private val PrimaryBackground = Color(0xFFE5E5E5)
private val SecondaryBackground = Color(0xFFF7F7F8)

val LightColorPalette = darkColors(
    primary = PrimaryViolet,
    background = PrimaryBackground,
    onBackground = SecondaryBackground
)

val DarkColorPalette = darkColors(
    primary = PrimaryViolet,
    background = PrimaryBackground,
    onBackground = SecondaryBackground
)
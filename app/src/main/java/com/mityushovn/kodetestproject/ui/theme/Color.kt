package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

private val Secondary = Color(0xFF6534FF) // для выделений
private val Surface = Color(0xFFF7F7F8) // для search bar
private val Background = Color(0xFFE5E5E5) // фон для списка
private val ErrorBackground = Color(0xFFF44336)
private val OnSurface = Color(0xFFC3C3C6) // цвет иконок на search bar, цвет шрифта хардкодил
private val PrimaryVariant = Color(0x29050510) // затемнение в modal sheet

/*
    1) primary - main brand color
    2) secondary for accent
    3) background and surface is for containers holding components
    4) "on" colors - use for content on top of one of the colors, example: text for surface is onSurface
 */
val LightColorPalette = lightColors(
    primaryVariant = PrimaryVariant,
    secondary = Secondary,
    onSecondary = Color.White,
    background = Background,
    surface = Surface,
    onSurface = OnSurface,
    error = ErrorBackground,
    onError = Color.White
)

val DarkColorPalette = darkColors(
    primaryVariant = PrimaryVariant,
    secondary = Secondary,
    onSecondary = Color.White,
    background = Background,
    surface = Surface,
    onSurface = OnSurface,
    error = ErrorBackground,
    onError = Color.White
)
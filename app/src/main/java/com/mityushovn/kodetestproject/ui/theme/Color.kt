package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Colors
 */
private val ContentActivePrimary = Color(0xFF6534FF) // для выделений
private val ContentActiveSecondary = Color(0xFF050510) // для выделений
private val ContentDefaultPrimary = Color(0xFFC3C3C6)
private val ContentDefaultSecondary =
    Color(0xFFC3C3C6) // цвет иконок на search bar, цвет шрифта хардкодил
private val Background = Color(0xFFE5E5E5) // фон для списка
private val BackgroundPrimary = Color(0xFFFFFFFF)
private val BackgroundSecondary = Color(0xFFF7F7F8) // для search bar
private val BackgroundTransparent = Color(0x29050510) // затемнение в modal sheet
private val ErrorBackground = Color(0xFFF44336)
private val TextPrimary = Color(0xFF050510) // черный для шрифтов при выделении
private val TextSecondary = Color(0xFF55555C)
private val TextTertiary = Color(0xFF97979B)
private val TextButton = Color(0xFFFFFFFF)
private val SkeletonGradient0 = Color(0xFFF3F3F6)
private val SkeletonGradient1 = Color(0xFFFAFAFA)


/**
 * [KodeColors] instance for the project theme
 */
val kodeLightColors = KodeColors(
    background = Background,
    backgroundPrimary = BackgroundPrimary,
    backgroundSecondary = BackgroundSecondary,
    backgroundTransparent = BackgroundTransparent,
    errorBackground = ErrorBackground,
    contentActivePrimary = ContentActivePrimary,
    contentActiveSecondary = ContentActiveSecondary,
    contentDefaultPrimary = ContentDefaultPrimary,
    contentDefaultSecondary = ContentDefaultSecondary,
    textPrimary = TextPrimary,
    textSecondary = TextSecondary,
    textTertiary = TextTertiary,
    textButton = TextButton,
    skeletonGradient0 = SkeletonGradient0,
    skeletonGradient1 = SkeletonGradient1
)

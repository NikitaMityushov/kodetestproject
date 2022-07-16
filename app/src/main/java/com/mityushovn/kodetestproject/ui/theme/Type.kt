package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.mityushovn.kodetestproject.R

private val InterBold = FontFamily(Font(R.font.inter_bold))
private val InterRegular = FontFamily(Font(R.font.inter_regular))
private val InterSemiBold = FontFamily(Font(R.font.inter_semibold))
private val InterMedium = FontFamily(Font(R.font.inter_medium))

/**
 * Fonts for the project.
 * Colors is hardcoded.
 */
val Title1Bold = TextStyle(
    fontFamily = InterBold,
    fontSize = 24.sp,
    lineHeight = 28.sp,
    color = Color(0xFF050510)
)

val Title2SemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 20.sp,
    lineHeight = 24.sp,
    color = Color(0xFF050510)
)

val Title3SemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 17.sp,
    lineHeight = 22.sp,
    color = Color(0xFF050510)
)

val HeadlineMedium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    color = Color(0xFF050510)
)

val HeadlineRegular = TextStyle(
    fontFamily = InterRegular,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    color = Color(0xFF97979B)
)

val HeadlineSemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 16.sp,
    lineHeight = 20.sp,
    color = Color(0xFF6534FF)
)

val CaptionRegular = TextStyle(
    fontFamily = InterRegular,
    fontSize = 13.sp,
    lineHeight = 16.sp,
    color = Color(0xFF55555C)
)

val TextSemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 15.sp,
    lineHeight = 20.sp,
    color = Color(0xFF050510)
)

val Text1Medium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
    color = Color(0xFFC3C3C6)
)

val Text2Medium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
    color = Color(0xFF97979B)
)

val Text3Medium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
    color = Color(0xFF050510)
)

val SubheadMedium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 14.sp,
    lineHeight = 18.sp,
    color = Color(0xFF97979B)
)

val SubheadSemibold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 14.sp,
    lineHeight = 18.sp,
    color = Color(0xFF6534FF)
)

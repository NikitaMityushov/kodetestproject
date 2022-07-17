package com.mityushovn.kodetestproject.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.mityushovn.kodetestproject.R

/**
 * Fonts for the project.
 */
private val InterBold = FontFamily(Font(R.font.inter_bold))
private val InterRegular = FontFamily(Font(R.font.inter_regular))
private val InterSemiBold = FontFamily(Font(R.font.inter_semibold))
private val InterMedium = FontFamily(Font(R.font.inter_medium))

private val Title1Bold = TextStyle(
    fontFamily = InterBold,
    fontSize = 24.sp,
    lineHeight = 28.sp,
//    color = Color(0xFF050510)
)

private val Title2SemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 20.sp,
    lineHeight = 24.sp,
//    color = Color(0xFF050510)
)

private val Title3SemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 17.sp,
    lineHeight = 22.sp,
//    color = Color(0xFF050510)
)

private val Title3Regular = TextStyle(
    fontFamily = InterRegular,
    fontSize = 17.sp,
    lineHeight = 22.sp,
//    color = Color(0xFF97979B)
)

private val HeadlineMedium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 16.sp,
    lineHeight = 20.sp,
//    color = Color(0xFF050510)
)

private val HeadlineRegular = TextStyle(
    fontFamily = InterRegular,
    fontSize = 16.sp,
    lineHeight = 20.sp,
//    color = Color(0xFF97979B)
)

private val HeadlineSemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 16.sp,
    lineHeight = 20.sp,
//    color = Color(0xFF6534FF)
)

private val CaptionRegular = TextStyle(
    fontFamily = InterRegular,
    fontSize = 13.sp,
    lineHeight = 16.sp,
//    color = Color(0xFF55555C)
)

private val TextSemiBold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 15.sp,
    lineHeight = 20.sp,
//    color = Color(0xFF050510)
)

private val Text1Medium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
//    color = Color(0xFFC3C3C6)
)

private val Text2Medium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
//    color = Color(0xFF97979B)
)

private val Text3Medium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 15.sp,
    lineHeight = 20.sp,
//    color = Color(0xFF050510)
)

private val SubheadMedium = TextStyle(
    fontFamily = InterMedium,
    fontSize = 14.sp,
    lineHeight = 18.sp,
//    color = Color(0xFF97979B)
)

private val SubheadSemibold = TextStyle(
    fontFamily = InterSemiBold,
    fontSize = 14.sp,
    lineHeight = 18.sp,
//    color = Color(0xFF6534FF)
)

/**
 * Typography instance for the project theme
 */
val kodeTypography = KodeTypography(
    title1Bold = Title1Bold,
    title2SemiBold = Title2SemiBold,
    title3SemiBold = Title3SemiBold,
    title3Regular = Title3Regular,
    headlineMedium = HeadlineMedium,
    headlineRegular = HeadlineRegular,
    headlineSemiBold = HeadlineSemiBold,
    caption1Regular = CaptionRegular,
    textSemiBold = TextSemiBold,
    textMedium = Text1Medium,
    subheadMedium = SubheadMedium,
    subheadSemiBold = SubheadSemibold
)

package com.mityushovn.kodetestproject.utils.mvi_interfaces

/**
 * Marker interface for MVI UI events(actions).
 * Intent in MVI terminology.
 */
interface UiIntent

/**
 * Created for initial StateFlow's initial value.
 */
object EmptyUiIntent : UiIntent
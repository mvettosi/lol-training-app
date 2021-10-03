package com.mvettosi.loltraining.entrypoint.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette =
    darkColors(
        primary = Nord9,
        primaryVariant = Nord10,
        onPrimary = Nord6,
        secondary = Nord8,
        secondaryVariant = Nord7,
        onSecondary = Nord0,
        background = Nord0,
        onBackground = Nord5,
        surface = Nord1,
        onSurface = Nord4,
        error = Nord11,
        onError = Nord6)

private val LightColorPalette =
    lightColors(
        primary = Nord9,
        primaryVariant = Nord10,
        onPrimary = Nord6,
        secondary = Nord8,
        secondaryVariant = Nord7,
        onSecondary = Nord0,
        background = Nord6,
        onBackground = Nord3,
        surface = Nord4,
        onSurface = Nord1,
        error = Nord11,
        onError = Nord0)

@Composable
fun TempTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colors =
      if (darkTheme) {
        DarkColorPalette
      } else {
        LightColorPalette
      }

  MaterialTheme(colors = colors, typography = Typography, shapes = Shapes, content = content)
}

package com.mvettosi.loltraining.entrypoint.ui.navigation

sealed class Screen(val route: String) {
  object Home : Screen("home_screen")
  object Sample : Screen("sample_screen")
}

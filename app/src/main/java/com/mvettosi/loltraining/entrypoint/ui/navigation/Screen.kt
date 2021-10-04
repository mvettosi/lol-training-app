package com.mvettosi.loltraining.entrypoint.ui.navigation

sealed class Screen(val route: String) {
  object Book : Screen("book_screen")
  object Tasks : Screen("tasks_screen")
  object Log : Screen("log_screen")
}

package com.mvettosi.loltraining.entrypoint.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mvettosi.loltraining.entrypoint.ui.LogScreen
import com.mvettosi.loltraining.entrypoint.ui.book.Book
import com.mvettosi.loltraining.entrypoint.ui.lessons.LessonsScreen

@Composable
fun Navigation(navController: NavHostController) {
  Scaffold(bottomBar = { LolBottomBar(navController = navController) }) {
    NavHost(
        navController = navController,
        startDestination = Screen.Book.route,
        modifier = Modifier.fillMaxSize()) {
      composable(Screen.Book.route) {
        Book(navController = navController, viewModel = hiltViewModel(it))
      }
      composable(Screen.Lessons.route) { LessonsScreen(navController = navController) }
      composable(Screen.Log.route) { LogScreen(navController = navController) }
    }
  }
}

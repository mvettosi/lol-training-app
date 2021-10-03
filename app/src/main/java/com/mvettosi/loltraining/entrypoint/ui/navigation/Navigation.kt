package com.mvettosi.loltraining.entrypoint.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mvettosi.loltraining.entrypoint.ui.home.Home
import com.mvettosi.loltraining.entrypoint.ui.sample.Sample

@Composable
fun Navigation(navController: NavHostController) {
  NavHost(
      navController = navController,
      startDestination = Screen.Home.route,
      modifier = Modifier.fillMaxSize()) {
    composable(Screen.Home.route) {
      Home(navController = navController, viewModel = hiltViewModel(it))
    }
    composable(Screen.Sample.route) { Sample(navController = navController) }
  }
}

package com.mvettosi.loltraining.entrypoint.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mvettosi.loltraining.R

fun Screen.resourceId() =
    when (this) {
      Screen.Book -> R.string.book_screen_label
      Screen.Lessons -> R.string.lessons_screen_label
      Screen.Log -> R.string.log_screen_label
    }

@Composable
fun LolBottomBar(navController: NavHostController) {
  val items = listOf(Screen.Book, Screen.Lessons, Screen.Log)
  BottomNavigation {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    items.forEach { screen ->
      BottomNavigationItem(
          icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
          label = { Text(stringResource(screen.resourceId())) },
          selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
          onClick = {
            navController.navigate(screen.route) {
              // Pop up to the start destination of the graph to
              // avoid building up a large stack of destinations
              // on the back stack as users select items
              popUpTo(navController.graph.findStartDestination().id) { saveState = true }
              // Avoid multiple copies of the same destination when
              // reselecting the same item
              launchSingleTop = true
              // Restore state when reselecting a previously selected item
              restoreState = true
            }
          })
    }
  }
}

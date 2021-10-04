package com.mvettosi.loltraining.entrypoint.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mvettosi.loltraining.R

data class BarItemMetaData(
    @StringRes val resourceId: Int,
    val icon: ImageVector,
    @StringRes val descId: Int
)

fun Screen.meta() =
    when (this) {
      Screen.Book ->
          BarItemMetaData(
              resourceId = R.string.book_screen_label,
              icon = Icons.Filled.Book,
              descId = R.string.book_screen_desc)
      Screen.Tasks ->
          BarItemMetaData(
              resourceId = R.string.tasks_screen_label,
              icon = Icons.Filled.Task,
              descId = R.string.tasks_screen_desc)
      Screen.Log ->
          BarItemMetaData(
              resourceId = R.string.log_screen_label,
              icon = Icons.Filled.List,
              descId = R.string.log_screen_desc)
    }

@Composable
fun LolBottomBar(navController: NavHostController) {
  val items = listOf(Screen.Book, Screen.Tasks, Screen.Log)
  BottomNavigation {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    items.forEach { screen ->
      val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
      BottomNavigationItem(
          icon = {
            Icon(
                imageVector = screen.meta().icon,
                contentDescription = stringResource(id = screen.meta().descId),
                tint =
                    if (isSelected) MaterialTheme.colors.primary
                    else LocalContentColor.current.copy(alpha = LocalContentAlpha.current))
          },
          label = {
            Text(
                text = stringResource(screen.meta().resourceId),
                color = if (isSelected) MaterialTheme.colors.primary else Color.Unspecified)
          },
          selected = isSelected,
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

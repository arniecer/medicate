package com.medicate.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.medicate.app.R
import com.medicate.app.ui.components.PlaceholderScreen

private class Tab(
    val route: String,
    val labelRes: Int,
    val icon: ImageVector,
    val destination: (Long) -> String
)

private val tabs = listOf(
    Tab(Routes.HOME, R.string.nav_inicio, Icons.Default.Home, Routes::home),
    Tab(Routes.CALENDAR, R.string.nav_calendario, Icons.Default.DateRange, Routes::calendar),
    Tab(Routes.INVENTORY, R.string.nav_inventario, Icons.Default.ShoppingCart, Routes::inventory),
    Tab(Routes.ALERTS, R.string.nav_avisos, Icons.Default.Notifications, Routes::alerts)
)

private val profileArgs = listOf(
    navArgument(Routes.PROFILE_ID){ type = NavType.LongType }
)

@Composable
fun AppNavigation() {
    val nav = rememberNavController()
    val backStackEntry by nav.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val profileId = backStackEntry?.arguments?.getLong(Routes.PROFILE_ID)
    val showBottonBar = profileId != null && tabs.any { it.route == currentRoute }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            if (showBottonBar && profileId != null) {
                NavigationBar {
                    tabs.forEach { tab ->
                        NavigationBarItem(
                            selected = currentRoute == tab.route,
                            onClick = {
                                nav.navigate(tab.destination(profileId)){
                                    popUpTo(Routes.PROFILES)
                                    launchSingleTop = true
                                }
                            },
                            icon = { Icon(tab.icon, contentDescription = null)},
                            label = { Text(stringResource(tab.labelRes)) }
                        )
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = Routes.PROFILES,
            modifier = Modifier.padding(padding)
        ){
            composable(Routes.PROFILES){
                PlaceholderScreen(
                    title = "Perfiles",
                    buttonText = "Entra con perfil de prueba (id 1)",
                    onButtonClick = {
                        nav.navigate(Routes.home(1)) { launchSingleTop = true }
                    }
                )
            }
            composable(Routes.HOME, arguments = profileArgs){
                PlaceholderScreen("Inicio")
            }
            composable(Routes.CALENDAR, arguments = profileArgs){
                PlaceholderScreen("Calendario")
            }
            composable(Routes.INVENTORY, arguments = profileArgs){
                PlaceholderScreen("Inventario")
            }
            composable(Routes.ALERTS, arguments = profileArgs){
                PlaceholderScreen("Avisos")
            }
        }
    }
}

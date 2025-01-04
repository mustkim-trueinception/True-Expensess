package com.example.true_expensess.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable







sealed class DashboardRoutes : Route {
    @Serializable
    data object HomeRoute : DashboardRoutes()

    @Serializable
    data object BulkScansRoute : DashboardRoutes()

    @Serializable
    data object ThreatControlRoute : DashboardRoutes()

    @Serializable
    data object VpnFirewallRoute : DashboardRoutes()
}


@Composable
fun DashboardNavGraph(

    navHostController: NavHostController,
    navigateTo: (Route) -> Unit = {}
) {

    val localNavigator: (Route) -> Unit = { route ->
        if (route is DashboardRoutes)

        else
            navigateTo(route)
    }

    NavHost(
        navController = navHostController,
        startDestination = DashboardRoutes.HomeRoute
    ) {
        composable<DashboardRoutes.HomeRoute> {
            Accounts()
        }
        composable<DashboardRoutes.BulkScansRoute> {
            Records()
        }
        composable<DashboardRoutes.ThreatControlRoute> {
            Categories()
        }
        composable<DashboardRoutes.VpnFirewallRoute> {
           Home()
        }
    }
}
















@Composable
fun Home() {
    Box { Text(text = "Home") }
}

@Composable
fun Categories() {
    Box { Text(text = "Home") }
}

@Composable
fun Records() {
    Box { Text(text = "Home") }
}

@Composable
fun Accounts() {
    Box { Text(text = "Home") }
}
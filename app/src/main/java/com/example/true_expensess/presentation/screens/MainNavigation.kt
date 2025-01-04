package com.example.true_expensess.presentation.screens

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import kotlinx.serialization.Serializable


@Serializable
object MainNavigationRoute

fun NavGraphBuilder.mainNavigation(
    navController: NavController,
) {
    navigation<MainNavigationRoute>(
        startDestination =  DashboardRoute,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { 1000 },
            ) + fadeIn(animationSpec = tween(300))
        },
        popEnterTransition = {
            fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 },
            ) + fadeOut(animationSpec = tween(300))
        }
    ) {

        composable<DashboardRoute> {
            Dashboard() {
            }
        }

    }
}

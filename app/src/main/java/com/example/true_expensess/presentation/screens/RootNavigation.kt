package com.example.true_expensess.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



/* Just for type Safety of routes */
interface Route

@SuppressLint("SuspiciousIndentation")
@Composable
fun RootNavigation(modifier: Modifier

) {

    val navController = rememberNavController()


        NavHost(navController,
            startDestination = MainNavigationRoute,
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
            }) {


            /* Authenticated Routes */
            mainNavigation(navController = navController,
            )
        }
    }




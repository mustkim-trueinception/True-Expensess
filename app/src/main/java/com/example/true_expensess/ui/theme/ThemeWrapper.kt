@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package ai.truelink.app.ui.theme

import ai.truelink.app.core.data.dataStore.appSettings.AppThemeMode
import ai.truelink.app.ui.customTheme.Theme
import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


/**
 * Applies the TruelinkAppRev3Theme to its content and provides WindowSizeClasses.
 *
 * @param content Composable content that this function applies the theme to,
 * and provides the current WindowWidthSizeClass and WindowHeightSizeClass.
 */
@Composable
fun ThemeWrapper(
    appThemeMode: AppThemeMode = AppThemeMode.System,
    transparent: Boolean = false,
    content: @Composable (widthSizeClass: WindowWidthSizeClass, heightSizeClass: WindowHeightSizeClass) -> Unit
) {
    val context = LocalContext.current as Activity
    val window = calculateWindowSizeClass(activity = context)
    val widthSizeClass = window.widthSizeClass
    val heightSizeClass = window.heightSizeClass
    val isDarkTheme = when (appThemeMode) {
        AppThemeMode.System -> isSystemInDarkTheme()
        AppThemeMode.Light -> false
        AppThemeMode.Dark -> true
    }
    TruelinkAppRev3Theme(
        darkTheme = isDarkTheme
    ) {
        Theme(
            isDarkTheme = isDarkTheme
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = if (transparent) Color.Transparent else Theme.Mapped.Surface900
            ) {
                content(widthSizeClass, heightSizeClass)
            }
        }
    }
}


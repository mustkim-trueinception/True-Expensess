package shortener.truelink.app.presentation.components.layouts

import ai.truelink.app.presentation.components.buttons.CustomIconButton
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant
import ai.truelink.app.presentation.components.buttons.CustomIconButtonDefaults
import ai.truelink.app.presentation.components.buttons.CustomIconButtonShape
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.true_expensess.R
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.DynamicImageSource

enum class CustomTopAppBarSize {
    Small,
    Medium,
    Large
}

/**
 * Represents a customizable top app bar composable function. This top app bar can adapt its appearance based on the provided parameters,
 * such as size, title, leading and trailing composable, and more. It supports dynamic theming, optional leading and trailing actions,
 * and custom content padding. The top app bar's height and background color can change depending on the size parameter.
 *
 * @param modifier The modifier to be applied to the top app bar. Defaults to [Modifier].
 * @param title The title text to be displayed in the top app bar. Can be null, in which case no title is shown. Defaults to "Top App Bar".
 * @param size The size of the top app bar, affecting its height and font size. Defaults to [CustomTopAppBarSize.Small].
 * @param showLeading A boolean flag to show a default leading icon when true and no custom leading composable is provided. Defaults to false.
 * @param containerColor The background color of the top app bar. It changes based on the size parameter. Defaults to theme-based colors.
 * @param contentPadding The padding applied to the content inside the top app bar. Defaults to horizontal 20.dp and vertical 12.dp.
 * @param textStyle The text style applied to the title. Changes based on the size parameter. Defaults to theme-based typography.
 * @param fontWeight The font weight for the title text. Defaults to [FontWeight.Medium].
 * @param textAlign The alignment of the title text. Defaults to [TextAlign.Start].
 * @param onBackAction A lambda function that is invoked when the back action is clicked. No-op by default.
 * @param leading An optional composable function that defines a custom leading icon or widget. It receives the current size as a parameter.
 * @param trailing An optional composable function that defines custom trailing icons or widgets. It receives the current size as a parameter.
 * @param windowInsets The window insets to be applied to the top app bar. Defaults to content window insets defined in [ScaffoldDefaults].
 *
 * This composable function is designed to be flexible, allowing for various customizations while providing sensible defaults.
 *
 * @see CustomTopAppBarSize
 * @author Aman Singh @amansinghtech
 */
@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier,
    title: String? = "Top App Bar",
    size: CustomTopAppBarSize = CustomTopAppBarSize.Small,
    showLeading: Boolean = false,
    containerColor: Color = if (size == CustomTopAppBarSize.Large) Theme.Mapped.Surface800 else Theme.Mapped.Surface700,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    textStyle: TextStyle = when (size) {
        CustomTopAppBarSize.Small -> Theme.Typography.h6
        CustomTopAppBarSize.Medium -> Theme.Typography.h5
        CustomTopAppBarSize.Large -> Theme.Typography.h4
    },
    contentColor: Color = Theme.Mapped.Text.Active,
    fontWeight: FontWeight = FontWeight.Medium,
    textAlign: TextAlign = TextAlign.Start,
    onBackAction: () -> Unit = {},
    leading: (@Composable (size: CustomTopAppBarSize) -> Unit)? = null,
    trailing: (@Composable (size: CustomTopAppBarSize) -> Unit)? = null,
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(containerColor)
            .windowInsetsPadding(insets = windowInsets.only(sides = WindowInsetsSides.Top)),
        contentAlignment = Alignment.BottomStart,
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(contentPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (showLeading && leading == null)
                CustomIconButton(
                    onClick = onBackAction,
                    shape = CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED),
                    icon = DynamicImageSource.Local(R.drawable.ic_arrow_left, asVector = true),
                    colors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.INHERIT),
                    size = when (size) {
                        CustomTopAppBarSize.Small -> CustomIconButtonSize.SMALL
                        CustomTopAppBarSize.Medium -> CustomIconButtonSize.MEDIUM
                        CustomTopAppBarSize.Large -> CustomIconButtonSize.LARGE
                    },
                )
            else if (leading != null) {
                leading(size)
            }

            if (title != null)
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    maxLines = 1,
                    color = contentColor,
                    textAlign = textAlign,
                    style = textStyle,
                    fontWeight = fontWeight
                )

            if (trailing != null) {
                trailing(size)
            }

            /* Place holder box if the text is center and not trailing is passed */
            if (trailing == null && textAlign == TextAlign.Center) {
                Box(modifier = Modifier.size(48.dp))
            }

        }
    }
}


@Composable
fun StatusBarColor(
    statusBarColor: Color? = null,
    navigationBarColor: Color? = null,

) {

    val view = LocalView.current

    val systemTheme = isSystemInDarkTheme()
    val isLightAppearanceStatusBar by remember {
        derivedStateOf {
            when (true) {
                systemTheme -> true

                else -> false
            }
        }
    }

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            if (statusBarColor != null)
                window.statusBarColor = statusBarColor.toArgb()
            if (navigationBarColor != null)
                window.navigationBarColor = navigationBarColor.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                isLightAppearanceStatusBar
        }
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Unspecified.toArgb()
            window.navigationBarColor = Color.Unspecified.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                isLightAppearanceStatusBar
        }
    }
}
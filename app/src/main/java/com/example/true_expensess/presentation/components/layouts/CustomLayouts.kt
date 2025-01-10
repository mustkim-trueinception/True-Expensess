package shortener.truelink.app.presentation.components.layouts

import ai.truelink.app.presentation.components.alerts.CustomSnackbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.true_expensess.ui.customTheme.Theme

/**
 * A wrapper component that allows for the creation of base layouts with a compact design i.e. mobile devices.
 * This layout includes optional top app bar and bottom navigation components, and a content area
 * with customizable padding and window insets. The layout's container color can also be customized.
 *
 * @param containerColor The background color of the layout's container. Defaults to Surface900 from the app's theme.
 * @param topAppBar An optional composable function for the top app bar. If provided, it is displayed at the top of the layout.
 * @param bottomNavigation An optional composable function for the bottom navigation. If provided, it is displayed at the bottom of the layout.
 * @param contentPadding The padding to be applied around the content area. Defaults to horizontal 20.dp and vertical 16.dp.
 * @param windowInsets The window insets to be applied to the layout. Defaults to the content window insets defined in ScaffoldDefaults.
 * @param floatingActionButton An optional composable function for the floating action button. If provided, it is displayed at the bottom end of the layout.
 * @param content The main content of the layout. This is a composable function that represents the primary UI elements displayed within the layout.
 *
 * @author: Aman Singh @amansinghtech
 */
@Composable
fun CompactBaseLayout(
    containerColor: Color = Theme.Mapped.Surface900,
    snackbarHostState: SnackbarHostState? = null,
    topAppBar: (@Composable () -> Unit)? = null,
    bottomNavigation: (@Composable () -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    disableContentPadding: Boolean = false,
    floatingActionButton: (@Composable () -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = containerColor)
            .let {
                if (topAppBar == null) it.windowInsetsPadding(windowInsets) else it.windowInsetsPadding(
                    insets = windowInsets.only(sides = WindowInsetsSides.Bottom)
                )
            },
        color = containerColor
    ) {
        Column {
            topAppBar?.invoke()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .let {
                        if (!disableContentPadding) it.padding(contentPadding)
                        else it
                    },
            ) {
                content(contentPadding)

                /* Floating Action Button */
                if (floatingActionButton != null)
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(y = (-24).dp),
                    ) {
                        floatingActionButton.invoke()
                    }
                if (snackbarHostState != null) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                    ) {
                        CustomSnackbar(snackbarHostState)
                    }
                }
            }
            bottomNavigation?.invoke()
        }
    }
}


/**
 * A wrapper component that allows for the creation of base layouts with a medium size screen design i.e. tablet devices in portrait mode or foldable.
 * This layout includes optional top app bar and bottom navigation components, and a content area
 * with customizable padding and window insets. The layout's container color can also be customized.
 *
 * @param containerColor The background color of the layout's container. Defaults to Surface900 from the app's theme.
 * @param topAppBar An optional composable function for the top app bar. If provided, it is displayed at the top of the layout.
 * @param bottomNavigation An optional composable function for the bottom navigation. If provided, it is displayed at the bottom of the layout.
 * @param navRail An optional composable function for the navigation rails. If provided, it is displayed at the start of the layout.
 * @param contentPadding The padding to be applied around the content area. Defaults to horizontal 20.dp and vertical 16.dp.
 * @param windowInsets The window insets to be applied to the layout. Defaults to the content window insets defined in ScaffoldDefaults.
 * @param floatingActionButton An optional composable function for the floating action button. If provided, it is displayed at the bottom end of the layout.
 * @param content The main content of the layout. This is a composable function that represents the primary UI elements displayed within the layout.
 *
 * @author: Aman Singh @amansinghtech
 */
@Composable
fun MediumBaseLayout(
    containerColor: Color = Theme.Mapped.Surface900,
    snackbarHostState: SnackbarHostState? = null,
    topAppBar: (@Composable () -> Unit)? = null,
    bottomNavigation: (@Composable () -> Unit)? = null,
    navRail: (@Composable () -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(32.dp),
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    floatingActionButton: (@Composable () -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = containerColor)
            .let {
                if (topAppBar == null) it.windowInsetsPadding(windowInsets) else it.windowInsetsPadding(
                    insets = windowInsets.only(sides = WindowInsetsSides.Bottom)
                )
            },
        color = containerColor
    ) {
        Row {
            navRail?.invoke()
            Column {
                topAppBar?.invoke()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(contentPadding),
                ) {
                    content(contentPadding)
                    if (floatingActionButton != null)
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .offset(y = (-24).dp),
                        ) {
                            floatingActionButton.invoke()
                        }

                    if (snackbarHostState != null) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                        ) {
                            CustomSnackbar(snackbarHostState)
                        }
                    }
                }
                bottomNavigation?.invoke()
            }
        }
    }
}

/**
 * Defines a layout structure for expanded screen sizes, such as desktop or large tablets.
 * This layout supports a navigation rail, a fixed content area, and a main(responsive) content area, allowing for a flexible and adaptive UI design.
 *
 * @param modifier Modifier for the Row layout, allowing customization of its appearance and behavior.
 * @param horizontalArrangement Defines the horizontal arrangement of the content within the Row.
 * @param windowInsets Defines the window insets to be applied to the layout, affecting the padding applied to the content areas.
 * @param fixedContentTopAppBar An optional composable function for displaying a top app bar in the fixed content area.
 * @param fixedContentPadding Padding to be applied around the fixed content area.
 * @param fixedContentContainerColor Background color for the fixed content container.
 * @param contentTopAppBar An optional composable function for displaying a top app bar in the main content area.
 * @param contentPadding Padding to be applied around the main content area.
 * @param contentContainerColor Background color for the main content container.
 * @param navRail An optional composable function for displaying a navigation rail at the start of the layout.
 * @param fixedContent An optional composable function for displaying fixed content, such as a sidebar or a menu.
 * @param floatingActionButton An optional composable function for displaying a floating action button.
 * @param content The main content of the layout, typically the primary UI elements displayed within the layout.
 *
 * @author: Aman Singh @amansinghtech
 */
@Composable
fun ExpandedBaseLayout(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState? = null,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(0.dp),
    windowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    fixedContentTopAppBar: (@Composable () -> Unit)? = null,
    fixedContentPadding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 24.dp),
    fixedContentContainerColor: Color = Theme.Mapped.Surface800,
    contentTopAppBar: (@Composable () -> Unit)? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 32.dp, vertical = 24.dp),
    contentContainerColor: Color = Theme.Mapped.Surface900,
    navRail: (@Composable () -> Unit)? = null,
    fixedContent: (@Composable () -> Unit)? = null,
    floatingActionButton: (@Composable () -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Row(modifier, horizontalArrangement = horizontalArrangement) {
        if (navRail != null) navRail()
        if (fixedContent != null) {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(443.dp),
                color = fixedContentContainerColor
            ) {
                Column {
                    fixedContentTopAppBar?.invoke()
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .let {
                                if (fixedContentTopAppBar == null) it.windowInsetsPadding(
                                    windowInsets
                                ) else it.windowInsetsPadding(
                                    insets = windowInsets.only(sides = WindowInsetsSides.Bottom)
                                )
                            }
                            .padding(fixedContentPadding),
                    ) {
                        fixedContent()
                    }
                }
            }
        }
        Surface(
            modifier = Modifier.fillMaxHeight(),
            color = contentContainerColor
        ) {
            Column {
                contentTopAppBar?.invoke()
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .let {
                            if (contentTopAppBar == null) it.windowInsetsPadding(windowInsets) else it.windowInsetsPadding(
                                insets = windowInsets.only(sides = WindowInsetsSides.Bottom)
                            )
                        }
                        .padding(contentPadding)
                ) {
                    content(contentPadding)
                    if (floatingActionButton != null) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .offset(y = (-24).dp),
                        ) {
                            floatingActionButton.invoke()
                        }
                    }
                    if (snackbarHostState != null) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        ) {
                            CustomSnackbar(snackbarHostState)
                        }
                    }
                }
            }
        }
    }
}


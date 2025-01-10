package ai.truelink.app.presentation.components.tabination

import ai.truelink.app.presentation.components.tabination.CustomTabDefaults.colors
import ai.truelink.app.presentation.components.tabination.CustomTabDefaults.sizeProperties
import ai.truelink.app.presentation.components.tabination.CustomTabSize.MEDIUM
import ai.truelink.app.presentation.components.tabination.CustomTabSize.SMALL
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.true_expensess.presentation.components.badges.BadgeSize
import com.example.true_expensess.presentation.components.badges.CustomBadgeColors
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * Defines the color scheme for custom tabs, including states for default, hover, active, and disabled.
 *
 * @property indicatorColor Default color of the tab indicator.
 * @property contentColor Default color of the tab content (text, icons).
 * @property containerColor Default background color of the tab.
 * @property hoverIndicatorColor Color of the tab indicator on hover.
 * @property hoverContentColor Color of the tab content on hover.
 * @property hoverContainerColor Background color of the tab on hover.
 * @property activeIndicatorColor Color of the tab indicator when the tab is active.
 * @property activeContentColor Color of the tab content when the tab is active.
 * @property activeContainerColor Background color of the tab when it is active.
 * @property disabledContainerColor Background color of the tab when it is disabled.
 * @property disabledContentColor Color of the tab content when it is disabled.
 * @property disabledIndicatorColor Color of the tab indicator when it is disabled.
 *
 * @constructor Create empty Custom tab colors
 *
 */
data class CustomTabColors(
    val indicatorColor: Color,
    val pilledIndicatorColor: Color,
    val contentColor: Color,
    val containerColor: Color,

    val hoverIndicatorColor: Color,
    val hoverContentColor: Color,
    val hoverContainerColor: Color,

    val activeIndicatorColor: Color,
    val activeContentColor: Color,
    val activeContainerColor: Color,

    val disabledContainerColor: Color,
    val disabledPilledIndicatorColor: Color,
    val disabledContentColor: Color,
    val disabledIndicatorColor: Color,
) {
    companion object {
        /**
         * Provides default color values for custom tabs.
         */
        val Default
            @Composable
            get() = CustomTabColors(
                indicatorColor = Theme.Mapped.Shade800,
                pilledIndicatorColor = Theme.Mapped.Surface50,
                contentColor = Theme.Mapped.Text.Inactive,
                containerColor = Color.Transparent,

                hoverIndicatorColor = Theme.Mapped.Shade500,
                hoverContentColor = Theme.Mapped.Text.Active,
                hoverContainerColor = Color.Transparent,

                activeIndicatorColor = Theme.System.Primary500,
                activeContentColor = Theme.Mapped.Text.Active,
                activeContainerColor = Theme.Mapped.Shade700,

                disabledContainerColor = Color.Transparent,
                disabledPilledIndicatorColor = Theme.Mapped.Shade800,
                disabledContentColor = Theme.Mapped.Text.Disabled,
                disabledIndicatorColor = Theme.Mapped.Shade800,
            )
    }

    /**
     * Determines the appropriate container color based on the tab's state.
     *
     * @param enabled Indicates if the tab is enabled.
     * @param hovered Indicates if the tab is being hovered over.
     * @param pressed Indicates if the tab is activated.
     * @return The color to be used for the tab's container.
     *
     */
    @Stable
    internal fun containerColor(
        enabled: Boolean,
        hovered: Boolean = false,
        pressed: Boolean = false
    ): Color {
        return when {
            !enabled -> disabledContainerColor
            pressed -> activeContainerColor
            hovered -> hoverContainerColor
            else -> containerColor
        }
    }

    /**
     * Determines the appropriate indicator color based on the tab's state.
     *
     * @param enabled Indicates if the tab is enabled.
     * @param hovered Indicates if the tab is being hovered over.
     * @param active Indicates if the tab is activated.
     *
     * @return The color to be used for the tab's indicator.
     */
    @Stable
    internal fun indicatorColor(
        enabled: Boolean,
        hovered: Boolean = false,
        active: Boolean = false
    ): Color {
        return when {
            !enabled -> disabledIndicatorColor
            active -> activeIndicatorColor
            hovered -> hoverIndicatorColor
            else -> indicatorColor
        }
    }

    /**
     * Determines the appropriate pilled indicator color based on the tab's state.
     *
     * @param enabled Indicates if the tab is enabled.
     * @param hovered Indicates if the tab is being hovered over.
     * @param active Indicates if the tab is activated.
     *
     * @return The color to be used for the tab's pilled indicator.
     */
    @Stable
    internal fun pilledIndicatorColor(
        enabled: Boolean,
        hovered: Boolean = false,
        active: Boolean = false
    ): Color {
        return when {
            !enabled -> disabledPilledIndicatorColor
            active -> pilledIndicatorColor
            hovered -> hoverIndicatorColor
            else -> pilledIndicatorColor
        }
    }

    /**
     * Determines the appropriate content color based on the tab's state.
     *
     * @param enabled Indicates if the tab is enabled.
     * @param hovered Indicates if the tab is being hovered over.
     * @param active Indicates if the tab is activated.
     *
     * @return The color to be used for the tab's content.
     */
    @Stable
    internal fun contentColor(
        enabled: Boolean,
        hovered: Boolean = false,
        active: Boolean = false
    ): Color {
        return when {
            !enabled -> disabledContentColor
            active -> activeContentColor
            hovered -> hoverContentColor
            else -> contentColor
        }
    }
}

/**
 * Represents properties for a custom tab item to customize its [CustomTab] appearance.
 *
 * @property text The text to be displayed on the center of the tab.
 * @property onClick The action to be performed when the tab is clicked.
 * If not provided, the tab will be call onChange function with the tab index.
 * It is optional, use this property to handle the click event and call third-party functions.
 * @property icon The icon to be displayed on the start of the tab.
 * @property iconCustomization Customization options for the icon.
 * @property count The count to be displayed on the badge on the end of the tab.
 * @property enabled Indicates if the tab is enabled.
 * @property modifier The modifier to be applied to the tab.
 * @property badgeColors The colors to be used for the badge.
 * it is a function that takes a boolean parameter indicating if the tab is active and returns [CustomBadgeColors].
 *
 * @constructor Create Custom tab item properties
 */
data class CustomTabItem(
    val text: String? = null,
    val onClick: () -> Unit = {},
    val icon: DynamicImageSource? = null,
    val iconCustomization: ImageCustomization? = null,
    val count: Int? = null,
    val enabled: Boolean = true,
    val modifier: Modifier = Modifier,
    val badgeColors: @Composable ((selected: Boolean) -> CustomBadgeColors)? = null,
)

/**
 * Custom Tab Size
 *
 * @property SMALL Represents a small custom tab size.
 * @property MEDIUM Represents a medium custom tab size.
 *
 * @constructor Create Custom tab size
 */
enum class CustomTabSize {
    SMALL,
    MEDIUM,
}

/**
 * Represents the dynamic properties for custom tab based on the selected size.
 *
 * @property minHeight The minimum height of the tab.
 * @property contentPadding The padding to be applied to the tab.
 * @property iconSize The size of the icon.
 * @property textStyle The style to be applied to the tab text.
 * @property badgeSize The size of the badge.
 *
 * @constructor Create Custom tab size properties
 */
data class CustomTabSizeProperties(
    val minHeight: Dp,
    val contentPadding: PaddingValues,
    val iconSize: Dp,
    val textStyle: TextStyle,
    val badgeSize: BadgeSize,
)

/**
 * Provides default values for custom tabs.
 *
 * @property colors The default [CustomTabColors] for custom tabs.
 * @property sizeProperties The default [CustomTabSizeProperties] for custom tabs.
 *
 * @see CustomTabColors
 * @see CustomTabSizeProperties
 *
 */
object CustomTabDefaults {
    /**
     * Provides default color values for custom tabs.
     *
     * @return The default [CustomTabColors] for custom tabs.
     *
     * @see CustomTabColors
     *
     */
    val colors: CustomTabColors
        @Composable
        get() = CustomTabColors.Default

    /**
     * Provides default dynamic properties for custom tabs based on the selected size.
     *
     * @param size The selected size of the custom tab.
     *
     * @return The default [CustomTabSizeProperties] for custom tabs.
     *
     * @see CustomTabSizeProperties
     * @see CustomTabSize
     *
     */
    val sizeProperties: @Composable (CustomTabSize) -> CustomTabSizeProperties = { size ->
        when (size) {
            SMALL -> CustomTabSizeProperties(
                minHeight = 40.dp,
                contentPadding = PaddingValues(
                    vertical = 10.dp,
                    horizontal = 4.dp
                ),
                iconSize = 20.dp,
                textStyle = Theme.Typography.l2.copy(
                    fontWeight = FontWeight.Medium
                ),
                badgeSize = BadgeSize.SMALL
            )

            MEDIUM -> CustomTabSizeProperties(
                minHeight = 48.dp,
                contentPadding = PaddingValues(
                    vertical = 12.dp,
                    horizontal = 8.dp
                ),
                iconSize = 24.dp,
                textStyle = Theme.Typography.l1.copy(
                    fontWeight = FontWeight.Medium
                ),
                badgeSize = BadgeSize.MEDIUM
            )
        }
    }
}
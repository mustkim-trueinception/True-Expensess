package com.example.true_expensess.presentation.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.true_expensess.presentation.components.buttons.CustomFabColorVariant.ERROR
import com.example.true_expensess.presentation.components.buttons.CustomFabColorVariant.INFO
import com.example.true_expensess.presentation.components.buttons.CustomFabColorVariant.PRIMARY
import com.example.true_expensess.presentation.components.buttons.CustomFabColorVariant.SECONDARY
import com.example.true_expensess.presentation.components.buttons.CustomFabColorVariant.SUCCESS
import com.example.true_expensess.presentation.components.buttons.CustomFabColorVariant.WARNING
import com.example.true_expensess.presentation.components.buttons.CustomFabDefaults.colors
import com.example.true_expensess.presentation.components.buttons.CustomFabDefaults.sizeProperties
import com.example.true_expensess.presentation.components.buttons.CustomFabSize.Large
import com.example.true_expensess.presentation.components.buttons.CustomFabSize.Medium
import com.example.true_expensess.presentation.components.buttons.CustomFabSize.Small
import com.example.true_expensess.ui.customTheme.Theme

/**
 * Represents the color scheme for a Custom Floating Action Button (Fab) including states for default, hover, active, and disabled.
 *
 * @property containerColor The default color of the Fab container.
 * @property contentColor The default color of the Fab content (e.g., icon or text).
 * @property cornerLayerColor The default color of the Fab's corner layer.
 * @property hoverContainerColor The color of the Fab container when hovered.
 * @property hoverContentColor The color of the Fab content when hovered.
 * @property hoverCornerLayerColor The color of the Fab's corner layer when hovered.
 * @property activeContainerColor The color of the Fab container when pressed or clicked.
 * @property activeContentColor The color of the Fab content when pressed or clicked.
 * @property activeCornerLayerColor The color of the Fab's corner layer when pressed or clicked.
 * @property disabledContainerColor The color of the Fab container when disabled.
 * @property disabledContentColor The color of the Fab content when disabled.
 * @property disabledCornerLayerColor The color of the Fab's corner layer when disabled.
 *
 * @constructor Creates a CustomFabColors object with the specified colors for the Fab.
 *
 */
data class CustomFabColors(
    val containerColor: Color,
    val contentColor: Color,
    val cornerLayerColor: Color,

    val hoverContainerColor: Color,
    val hoverContentColor: Color,
    val hoverCornerLayerColor: Color,

    val activeContainerColor: Color,
    val activeContentColor: Color,
    val activeCornerLayerColor: Color,

    val disabledContainerColor: Color,
    val disabledContentColor: Color,
    val disabledCornerLayerColor: Color
) {
    /**
     * Determines the appropriate container color based on the button's state.
     *
     * @param enabled Indicates if the button is enabled.
     * @param hovered Indicates if the button is being hovered over.
     * @param pressed Indicates if the button is being pressed.
     *
     * @return The color to be used for the background of the Fab container.
     */
    @Stable
    internal fun containerColor(enabled: Boolean, hovered: Boolean, pressed: Boolean): Color {
        return when {
            !enabled -> disabledContainerColor
            pressed -> activeContainerColor
            hovered -> hoverContainerColor
            else -> containerColor
        }
    }

    /**
     * Determines the appropriate content color based on the button's state.
     *
     * @param enabled Indicates if the button is enabled.
     * @param hovered Indicates if the button is being hovered over.
     * @param pressed Indicates if the button is being pressed.
     * @return The color to be used for the button's content.
     */
    @Stable
    internal fun contentColor(enabled: Boolean, hovered: Boolean, pressed: Boolean): Color {
        return when {
            !enabled -> disabledContentColor
            pressed -> activeContentColor
            hovered -> hoverContentColor
            else -> contentColor
        }
    }

    /**
     * Determines the appropriate corner layer color based on the button's state.
     *
     * @param enabled Indicates if the button is enabled.
     * @param hovered Indicates if the button is being hovered over.
     * @param pressed Indicates if the button is being pressed.
     * @return The color to be used for the button's corner layer.
     */
    @Stable
    internal fun cornerLayerColor(enabled: Boolean, hovered: Boolean, pressed: Boolean): Color {
        return when {
            !enabled -> disabledCornerLayerColor
            pressed -> activeCornerLayerColor
            hovered -> hoverCornerLayerColor
            else -> cornerLayerColor
        }
    }
}

/**
 * CustomFabColorVariant is a enum class that represents the different color variants for the CustomFab.
 *
 * @property PRIMARY Represents the primary color variant.
 * @property SECONDARY Represents the secondary color variant.
 * @property WARNING Represents the warning color variant.
 * @property ERROR Represents the error color variant.
 * @property SUCCESS Represents the success color variant.
 * @property INFO Represents the info color variant.
 *
 * @constructor Creates different color variants for the CustomFab.
 *
 * @see CustomFab
 * @see CustomFabColors
 *
 */
enum class CustomFabColorVariant {
    PRIMARY,
    SECONDARY,
    WARNING,
    ERROR,
    SUCCESS,
    INFO
}

/**
 * CustomFabSize is a enum class that represents the different size variants for the CustomFab.
 *
 * @property Small Represents the small size variant.
 * @property Medium Represents the medium size variant.
 * @property Large Represents the large size variant.
 *
 * @constructor Creates different size variants for the CustomFab.
 *
 * @see CustomFab
 * @see CustomFabSizeProperties
 *
 */
enum class CustomFabSize {
    Small,
    Medium,
    Large
}

/**
 * CustomFabSizeProperties is a data class that represents the size properties for the CustomFab.
 *
 * @property contentPadding The padding values for the container and content of the CustomFab.
 * @property shape The shape of the container of the CustomFab.
 * @property spacing The spacing between the icon and text of the CustomFab.
 * @property iconSize The size of the icon in the CustomFab.
 * @property textStyle The text style of the text in the CustomFab.
 * @property size The size of the CustomFab.
 * @property cornerLayerWidth The width of the corner layer of the CustomFab.
 * @property cornerLayerHeight The height of the corner layer of the CustomFab.
 *
 * @constructor Creates size properties for the CustomFab.
 *
 * @see CustomFab
 * @see CustomFabSize
 *
 */
data class CustomFabSizeProperties(
    val contentPadding: PaddingValues,
    val shape: Shape,
    val spacing: Dp,
    val iconSize: Dp,
    val textStyle: TextStyle,
    val size: Dp,
    val cornerLayerWidth: Dp,
    val cornerLayerHeight: Dp
)

/**
 * CustomFabDefaults is an object that provides default values for the CustomFab.
 *
 * @property colors Provides the default color scheme for the CustomFab based on the color variant.
 * @property sizeProperties Provides the size properties for the CustomFab based on the size variant.
 *
 * @constructor Creates default values for the CustomFab.
 *
 * @see CustomFab
 * @see CustomFabColors
 * @see CustomFabColorVariant
 * @see CustomFabSizeProperties
 * @see CustomFabSize
 *
 */
object CustomFabDefaults {

    private const val FAB_ALPHA = 0.30f

    /**
     * Provides the default color scheme for the CustomFab based on the [CustomFabColorVariant].
     *
     * @param variant The color variant of the CustomFab.
     *
     * @return The default [CustomFabColors] for the CustomFab.
     *
     * @see CustomFabColors
     * @see CustomFabColorVariant
     *
     */
    val colors: @Composable (CustomFabColorVariant) -> CustomFabColors = { variant ->
        when (variant) {
            CustomFabColorVariant.PRIMARY -> CustomFabColors(
                containerColor = Theme.Mapped.Primary.Main,
                contentColor = Theme.Mapped.Primary.TextMain,
                cornerLayerColor = Theme.Mapped.Primary.TextMain.copy(alpha = FAB_ALPHA),

                hoverContainerColor = Theme.Mapped.Primary.Hover,
                hoverContentColor = Theme.Mapped.Primary.TextHover,
                hoverCornerLayerColor = Theme.Mapped.Primary.TextMain.copy(alpha = FAB_ALPHA),

                activeContainerColor = Theme.Mapped.Primary.Pressed,
                activeContentColor = Theme.Mapped.Primary.TextPressed,
                activeCornerLayerColor = Theme.Mapped.Primary.TextMain.copy(alpha = FAB_ALPHA),

                disabledContainerColor = Theme.Mapped.Primary.Disabled,
                disabledContentColor = Theme.Mapped.Primary.TextDisabled,
                disabledCornerLayerColor = Color.Transparent
            )

            CustomFabColorVariant.SECONDARY -> CustomFabColors(
                containerColor = Theme.Mapped.Secondary.Main,
                contentColor = Theme.Mapped.Secondary.TextMain,
                cornerLayerColor = Theme.Mapped.Secondary.TextMain.copy(alpha = FAB_ALPHA),

                hoverContainerColor = Theme.Mapped.Secondary.Hover,
                hoverContentColor = Theme.Mapped.Secondary.TextHover,
                hoverCornerLayerColor = Theme.Mapped.Secondary.TextMain.copy(alpha = FAB_ALPHA),

                activeContainerColor = Theme.Mapped.Secondary.Pressed,
                activeContentColor = Theme.Mapped.Secondary.TextPressed,
                activeCornerLayerColor = Theme.Mapped.Secondary.TextMain.copy(alpha = FAB_ALPHA),

                disabledContainerColor = Theme.Mapped.Secondary.Disabled,
                disabledContentColor = Theme.Mapped.Secondary.TextDisabled,
                disabledCornerLayerColor = Color.Transparent
            )

            CustomFabColorVariant.WARNING -> CustomFabColors(
                containerColor = Theme.Mapped.Warning.Main,
                contentColor = Theme.Mapped.Warning.TextMain,
                cornerLayerColor = Theme.Mapped.Warning.TextMain.copy(alpha = FAB_ALPHA),

                hoverContainerColor = Theme.Mapped.Warning.Hover,
                hoverContentColor = Theme.Mapped.Warning.TextHover,
                hoverCornerLayerColor = Theme.Mapped.Warning.TextMain.copy(alpha = FAB_ALPHA),

                activeContainerColor = Theme.Mapped.Warning.Pressed,
                activeContentColor = Theme.Mapped.Warning.TextPressed,
                activeCornerLayerColor = Theme.Mapped.Warning.TextMain.copy(alpha = FAB_ALPHA),

                disabledContainerColor = Theme.Mapped.Warning.Disabled,
                disabledContentColor = Theme.Mapped.Warning.TextDisabled,
                disabledCornerLayerColor = Color.Transparent
            )

            CustomFabColorVariant.ERROR -> CustomFabColors(
                containerColor = Theme.Mapped.Error.Main,
                contentColor = Theme.Mapped.Error.TextMain,
                cornerLayerColor = Theme.Mapped.Error.TextMain.copy(alpha = FAB_ALPHA),

                hoverContainerColor = Theme.Mapped.Error.Hover,
                hoverContentColor = Theme.Mapped.Error.TextHover,
                hoverCornerLayerColor = Theme.Mapped.Error.TextMain.copy(alpha = FAB_ALPHA),

                activeContainerColor = Theme.Mapped.Error.Pressed,
                activeContentColor = Theme.Mapped.Error.TextPressed,
                activeCornerLayerColor = Theme.Mapped.Error.TextMain.copy(alpha = FAB_ALPHA),

                disabledContainerColor = Theme.Mapped.Error.Disabled,
                disabledContentColor = Theme.Mapped.Error.TextDisabled,
                disabledCornerLayerColor = Color.Transparent
            )

            CustomFabColorVariant.SUCCESS -> CustomFabColors(
                containerColor = Theme.Mapped.Success.Main,
                contentColor = Theme.Mapped.Success.TextMain,
                cornerLayerColor = Theme.Mapped.Success.TextMain.copy(alpha = FAB_ALPHA),

                hoverContainerColor = Theme.Mapped.Success.Hover,
                hoverContentColor = Theme.Mapped.Success.TextHover,
                hoverCornerLayerColor = Theme.Mapped.Success.TextMain.copy(alpha = FAB_ALPHA),

                activeContainerColor = Theme.Mapped.Success.Pressed,
                activeContentColor = Theme.Mapped.Success.TextPressed,
                activeCornerLayerColor = Theme.Mapped.Success.TextMain.copy(alpha = FAB_ALPHA),

                disabledContainerColor = Theme.Mapped.Success.Disabled,
                disabledContentColor = Theme.Mapped.Success.TextDisabled,
                disabledCornerLayerColor = Color.Transparent
            )

            CustomFabColorVariant.INFO -> CustomFabColors(
                containerColor = Theme.Mapped.Info.Main,
                contentColor = Theme.Mapped.Info.TextMain,
                cornerLayerColor = Theme.Mapped.Info.TextMain.copy(alpha = FAB_ALPHA),

                hoverContainerColor = Theme.Mapped.Info.Hover,
                hoverContentColor = Theme.Mapped.Info.TextHover,
                hoverCornerLayerColor = Theme.Mapped.Info.TextMain.copy(alpha = FAB_ALPHA),

                activeContainerColor = Theme.Mapped.Info.Pressed,
                activeContentColor = Theme.Mapped.Info.TextPressed,
                activeCornerLayerColor = Theme.Mapped.Info.TextMain.copy(alpha = FAB_ALPHA),

                disabledContainerColor = Theme.Mapped.Info.Disabled,
                disabledContentColor = Theme.Mapped.Info.TextDisabled,
                disabledCornerLayerColor = Color.Transparent
            )
        }
    }
    /* end colors */

    /**
     * Provides the size properties for the CustomFab based on the [CustomFabSize].
     *
     * @param size The size variant of the CustomFab.
     *
     * @return The default [CustomFabSizeProperties] for the CustomFab.
     *
     * @see CustomFabSizeProperties
     * @see CustomFabSize
     *
     */
    val sizeProperties: @Composable (CustomFabSize) -> CustomFabSizeProperties = { size ->
        when (size) {
            CustomFabSize.Small -> CustomFabSizeProperties(
                contentPadding = PaddingValues(12.dp),
                shape = RoundedCornerShape(8.dp),
                spacing = 4.dp,
                iconSize = 16.dp,
                textStyle = Theme.Typography.l3,
                size = 40.dp,
                cornerLayerWidth = 34.29.dp,
                cornerLayerHeight = 24.dp
            )

            CustomFabSize.Medium -> CustomFabSizeProperties(
                contentPadding = PaddingValues(16.dp),
                shape = RoundedCornerShape(12.dp),
                spacing = 8.dp,
                iconSize = 24.dp,
                textStyle = Theme.Typography.h6,
                size = 56.dp,
                cornerLayerWidth = 50.dp,
                cornerLayerHeight = 35.dp
            )

            CustomFabSize.Large -> CustomFabSizeProperties(
                contentPadding = PaddingValues(16.dp),
                shape = RoundedCornerShape(16.dp),
                spacing = 12.dp,
                iconSize = 32.dp,
                textStyle = Theme.Typography.h4,
                size = 64.dp,
                cornerLayerWidth = 57.dp,
                cornerLayerHeight = 40.dp
            )
        }
    }
    /* end sizeProperties */
}
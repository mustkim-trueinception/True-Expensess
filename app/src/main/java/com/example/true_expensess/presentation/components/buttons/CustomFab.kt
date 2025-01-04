package com.example.true_expensess.presentation.components.buttons

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.true_expensess.R
import com.example.true_expensess.presentation.components.image.DynamicImage
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * A composable function that creates a customizable Floating Action Button (FAB) with optional text and icon.
 * The FAB can be customized in terms of size, color, and icon. It supports interaction states such as hover and press.
 *
 * Example usage:
 * ```
 * CustomFab(
 *     icon = DynamicImageSource.Vector(Icons.Default.Circle),
 *     text = "Custom FAB",
 *     size = CustomFabSize.Large,
 *     // enabled = false,
 *     colors = CustomFabDefaults.colors(CustomFabColorVariant.SUCCESS),
 *     onClick = { }
 * )
 * ```
 *
 * @param modifier A [Modifier] for applying layout and other visual behaviors to this composable. Defaults to [Modifier].
 * @param icon A [DynamicImageSource] representing the icon to be displayed inside the FAB.
 * @param text An optional [String] to display alongside the icon. Defaults to null, meaning no text is displayed.
 * @param enabled A [Boolean] indicating if the FAB is enabled. When false, the FAB will not respond to interactions. Defaults to true.
 * @param size A [CustomFabSize] determining the size of the FAB. Affects the padding and icon size. Defaults to [CustomFabSize.Medium].
 * @param iconCustomization An [ImageCustomization] object to further customize the icon's appearance. Defaults to [ImageCustomization.Default].
 * @param colors A [CustomFabColors] instance defining the color scheme of the FAB based on its state (normal, hovered, pressed, disabled).
 * @param interactionSource A [MutableInteractionSource] tracking the interaction state of the FAB. Used to change visual state based on user interaction.
 * @param onClick A lambda expression that will be invoked when the FAB is clicked.
 *
 *
 * - This FAB supports dynamic visual feedback based on interaction states such as hover and press, by changing its background and content colors accordingly.
 * - The optional text, if provided, is displayed next to the icon. The FAB's size and padding can be customized through the [size] parameter.
 * - The [colors] parameter allows for detailed customization of the FAB's color scheme, including separate colors for different states (enabled, hovered, pressed, and disabled).
 *
 * @see CustomFabSize
 * @see CustomFabColors
 * @see CustomFabDefaults
 * @see ImageCustomization
 * @see DynamicImageSource
 * @see DynamicImage
 *
 * @author Deepak Yadu @deepak404found
 *
 */
@Composable
fun CustomFab(
    modifier: Modifier = Modifier,
    icon: DynamicImageSource,
    text: String? = null,
    enabled: Boolean = true,
    size: CustomFabSize = CustomFabSize.Medium,
    iconCustomization: ImageCustomization = ImageCustomization.Default,
    colors: CustomFabColors = CustomFabDefaults.colors(CustomFabColorVariant.PRIMARY),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {
    val dynamicProperties = CustomFabDefaults.sizeProperties(size)

    /* interaction */
    val isPressed by interactionSource.collectIsPressedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()

    /* main stack */
    Box(
        modifier = modifier
            .wrapContentWidth()
            .clip(dynamicProperties.shape)
            .clickable(
                enabled = enabled,
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick
            )
            .sizeIn(dynamicProperties.size)
            .background(
                color = colors.containerColor(
                    enabled = enabled,
                    pressed = isPressed,
                    hovered = isHovered
                ),
                shape = dynamicProperties.shape
            )
    ) {
        /* fab container */
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                dynamicProperties.spacing,
                Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentSize()
                .padding(dynamicProperties.contentPadding)
        ) {
            /* dynamic styles for text and icon */
            val contentColor = colors.contentColor(
                enabled = enabled,
                pressed = isPressed,
                hovered = isHovered
            )
            val mergedStyle = LocalTextStyle.current.merge(dynamicProperties.textStyle)

            /* composition container */
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides mergedStyle,
                content = {
                    /* icon */
                    DynamicImage(
                        icon, customization = iconCustomization.copy(
                            tint = contentColor
                        ),
//                        modifier = Modifier
//                            .requiredSize(dynamicProperties.iconSize)
                    )

                    /* text */
                    text?.let {
                        Text(
                            text = it,
                            style = dynamicProperties.textStyle,
                            fontWeight = FontWeight.Medium,
                            color = contentColor
                        )
                    }
                }
            )
            /* end composition container */
        }
        /* end fab container */

        /* corner layer */
        DynamicImage(
            imageSource = DynamicImageSource.Local(R.drawable.fab_corner_layer, true),
            customization = ImageCustomization.Default.copy(
                tint = colors.cornerLayerColor(
                    enabled = enabled,
                    pressed = isPressed,
                    hovered = isHovered
                )
            ),
//            modifier = Modifier
//                .align(Alignment.BottomEnd)
//                .requiredSize(
//                    dynamicProperties.cornerLayerWidth,
//                    dynamicProperties.cornerLayerHeight
//                )
        )
        /* end corner layer */
    }
    /* end main stack */
}
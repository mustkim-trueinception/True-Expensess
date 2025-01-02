package shortener.truelink.app.presentation.components.bages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * CustomBadge is a composable that is used to display a badge with a label and optional icons.
 *
 * Example usage:
 *
 * - Default badge with label:
 * ```
 * CustomBadge(
 *     // modifier = Modifier.size(16.dp),
 *     label = "text",
 *     size = BadgeSize.LARGE,
 *     colors = CustomBadgeDefaults.colors(CustomBadgeColorVariant.WARNING),
 *     enabled = false,
 *     startIcon = { size ->
 *         DynamicImage(
 *             imageSource = DynamicImageSource.Local(R.drawable.ic_loading),
 *             modifier = Modifier.size(size)
 *         )
 *     },
 *     endIcon = { size ->
 *         DynamicImage(
 *             imageSource = DynamicImageSource.Vector(Icons.Default.AccountCircle),
 *             modifier = Modifier.size(size)
 *         )
 *     }
 * )
 * ```
 *
 * - Dot badge:
 * ```
 * CustomBadge(
 *     enabled = true,
 *     colors = CustomBadgeDefaults.colors(CustomBadgeColorVariant.SUCCESS),
 * )
 * ```
 *
 * - Counter badge:
 * ```
 * CustomBadge(
 *     label = "1",
 *     enabled = true,
 *     colors = CustomBadgeDefaults.colors(CustomBadgeColorVariant.ERROR),
 *     size = BadgeSize.MEDIUM,
 * )
 * ```
 *
 * @param label The text to display in the badge.
 * if the label is null, the badge will be displayed as a dot.
 *
 * @param enabled Whether the badge is enabled or disabled.
 * @param modifier The modifier to apply to the badge.
 * @param size The size of the badge. {@default BadgeSize.MEDIUM}
 * @param colors The colors to use for the badge. {@default CustomBadgeDefaults.colors(CustomBadgeColorVariant.PRIMARY)}
 * @param startIcon The composable to display at the start of the badge.
 * @param endIcon The composable to display at the end of the badge.
 *
 * @see CustomBadgeDefaults
 * @see CustomBadgeColors
 * @see CustomBadgeColorVariant
 * @see BadgeSize
 *
 * @author Deepak Yadu @deepak404found
 *
 */
@Composable
fun CustomBadge(
    modifier: Modifier = Modifier,
    label: String? = null,
    enabled: Boolean = true,
    size: BadgeSize = BadgeSize.MEDIUM,
    shape: RoundedCornerShape = CustomBadgeDefaults.shape,
    colors: CustomBadgeColors = CustomBadgeDefaults.colors(CustomBadgeColorVariant.PRIMARY),
    startIcon: @Composable ((
        size: Dp,
    ) -> Unit)? = null,
    endIcon: @Composable ((
        size: Dp,
    ) -> Unit)? = null,
) {
    val dynamicProperties = CustomBadgeDefaults.dynamicProperties(size, label != null)

    /* main stack */
    Row(
        modifier = modifier
            .defaultMinSize(
                minWidth = dynamicProperties.minWidth,
                minHeight = dynamicProperties.minHeight,
            )
            .background(
                color = colors.containerColor(enabled),
                shape = shape
            )
            .clip(shape)
            .let {
                if (dynamicProperties.contentPadding != null) it.padding(dynamicProperties.contentPadding)
                else it
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (label != null) {
            val contentColor = colors.labelColor(enabled)
            val mergedStyle = LocalTextStyle.current.merge(dynamicProperties.textStyle)
            CompositionLocalProvider(
                LocalContentColor provides contentColor,
                LocalTextStyle provides mergedStyle,
                content = {
                    /* badge content */
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(
                            4.dp,
                            Alignment.CenterHorizontally
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        /* startIcon */
                        if (startIcon != null) startIcon(dynamicProperties.iconSize ?: 0.dp)


                        /* label */
                        Text(
                            text = label,
                            style = mergedStyle,
                            color = contentColor
                        )

                        /* endIcon */
                        if (endIcon != null) endIcon(dynamicProperties.iconSize ?: 0.dp)

                    }
                    /* end badge content */
                }
            )
        }
    }
    /* end main stack */
}
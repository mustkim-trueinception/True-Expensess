package shortener.truelink.app.presentation.components.menuItem


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.true_expensess.presentation.components.image.DynamicImage
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * This Menu List Item is used for displaying a list of actions or options in a menu.
 * A composable function that creates a customizable menu list item with optional leading and trailing icons,
 * text content, and an optional trailing composable element. It supports click actions, selection state,
 * and enabled/disabled state.
 *
 * @param label The primary text label for the menu item. Defaults to "Label".
 * @param description An optional secondary text description for more detail. Defaults to null.
 * @param leadingIcon An optional leading icon displayed before the text content. Defaults to null.
 * @param trailingIcon An optional trailing icon displayed after the text content. Defaults to null.
 * @param onClick An optional lambda function that is invoked when the menu item is clicked. Defaults to null.
 * @param paddingValues Padding around the menu item. Defaults to 12.dp.
 * @param isSelected Boolean flag indicating if the menu item is currently selected. Defaults to false.
 * @param enabled Boolean flag indicating if the menu item is enabled. Defaults to true.
 * @param trailingText An optional text displayed at the end of the menu item. Defaults to null.
 * @param trailingElement An optional composable lambda that allows adding custom trailing content. Defaults to null.
 * @author Aman Singh @amansinghtech
 */
@Composable
fun MenuListItem(
    label: String = "Label",
    description: String? = null,
    leadingIcon: DynamicImageSource? = null,
    trailingIcon: DynamicImageSource? = null,
    onClick: (() -> Unit)? = null,
    paddingValues: PaddingValues = PaddingValues(12.dp),
    isSelected: Boolean = false,
    enabled: Boolean = true,
    trailingText: String? = null,
    trailingElement: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (!enabled) Theme.Mapped.Surface500 else if (isSelected) Theme.Mapped.Surface300 else Color.Transparent)
            .fillMaxWidth()
            .let { if (onClick != null && enabled) it.clickable { onClick.invoke() } else it }
            .padding(paddingValues)
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        leadingIcon?.let {
            DynamicImage(
                imageSource = leadingIcon,
                customization = ImageCustomization(
                    modifier = Modifier.size(24.dp),
                    tint = if (enabled) Theme.Mapped.Text.Active else Theme.Mapped.Text.Disabled
                )
            )
        }

        /* Text Content */
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = Theme.Typography.l1,
                fontWeight = FontWeight.Medium,
                color = if (enabled) Theme.Mapped.Text.Active else Theme.Mapped.Text.Disabled
            )
            description?.let {
                Text(
                    text = description,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = Theme.Typography.l2,
                    fontWeight = FontWeight.Normal,
                    color = if (enabled) Theme.Mapped.Text.Inactive else Theme.Mapped.Text.Disabled
                )
            }
        }

        /* Trailing Element */
        trailingElement?.invoke()

        trailingText?.let {
            Text(
                text = trailingText,
                style = Theme.Typography.l2,
                fontWeight = FontWeight.Medium,
                color = if (enabled) Theme.Mapped.Text.Inactive else Theme.Mapped.Text.Disabled
            )
        }

        /* Trailing Icon */
        trailingIcon?.let {
            DynamicImage(
                imageSource = it,
                customization = ImageCustomization(
                    modifier = Modifier.size(24.dp),
                    tint = if (enabled) Theme.Mapped.Text.Active else Theme.Mapped.Text.Disabled
                )
            )
        }
    }
}
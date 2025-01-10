package shortener.truelink.app.presentation.components.menuItem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.sp
import com.example.true_expensess.presentation.components.image.DynamicImage
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * This list Item is used for displaying a list of shortened links.
 * A composable function that created a customizable list item with optional trailing and barchart icons,
 * text content, and an optional trailing text.
 *
 * @param date The date of the scan for the shortened link. Defaults to "Jun 26".
 * @param title The title of the shortened link. Defaults to "Top Selling Courses".
 * @param url The URL of the shortened link. Defaults to "www.facebook.com/tech2secure/all-in-one-courses".
 * @param shortURL The short URL of the shortened link. Defaults to "trly.me/u/25nvwo3".
 * @param trailingIcon The icon to display at the end of the list item. Defaults to null.
 * @param barchartIcon The icon to display the barchart at the end of the list item. Defaults to null.
 * @param onClick A lambda function that is invoked when the list item is clicked. Defaults to null.
 * @param paddingValues Padding around the list item. Defaults to PaddingValues 8.dp.
 * @param isSelected Whether the list item is selected or not. Defaults to false.
 * @param enabled Whether the list item is enabled or not. Defaults to true.
 * @param trailingText An optional text displayed at the end of the list item.Defaults to null.
 * */
@Composable
fun ListItem(
    date: String = "Jun 26",
    title: String = "Top Selling Courses",
    url: String = "www.facebook.com/tech2secure/all-in-one-courses",
    shortURL: String = "trly.me/u/25nvwo3",
    trailingIcon: DynamicImageSource? = null,
    barchartIcon: DynamicImageSource? = null,
    onClick: (() -> Unit)? = null,
    paddingValues: PaddingValues = PaddingValues(8.dp),
    isSelected: Boolean = false,
    enabled: Boolean = true,
    trailingText: String? = null,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (!enabled) Theme.Mapped.Surface500 else if (isSelected) Theme.Mapped.Surface300 else Color.Transparent)
            .fillMaxWidth()
            .let { if (onClick != null && enabled) it.clickable { onClick.invoke() } else it }
            .padding(paddingValues)
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row(modifier = Modifier.padding(vertical = 4.dp)) {
                /* Date and Title text */
                Text(
                    text = date,
                    style = Theme.Typography.l1.copy(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (enabled) Theme.Mapped.Text.Inactive else Theme.Mapped.Text.Disabled
                    )
                )
                Text(
                    text = " | ",
                    style = Theme.Typography.l1.copy(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (enabled) Theme.Mapped.Text.Inactive else Theme.Mapped.Text.Disabled
                    )
                )
                Text(
                    text = title,
                    maxLines = 1,
                    style = Theme.Typography.l1.copy(
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (enabled) Theme.Mapped.Text.Inactive else Theme.Mapped.Text.Disabled
                    )
                )
            }

            /* URL and Short URL text */
            Text(
                text = url,
                style = Theme.Typography.l2,
                fontWeight = FontWeight.SemiBold,
                color = if (enabled) Theme.Mapped.Text.Active else Theme.Mapped.Text.Disabled
            )

            Text(
                text = shortURL,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = Theme.Typography.l2.copy(
                    lineHeight = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Theme.Base.Cyan500
                )
            )
        }

        Column(
            modifier = Modifier.weight(1f).fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            /* Trailing icon */
            trailingIcon?.let {
                DynamicImage(
                    imageSource = it,
                    customization = ImageCustomization(
                        modifier = Modifier.size(24.dp),
                        tint = if (enabled) Theme.Mapped.Text.Active else Theme.Mapped.Text.Disabled
                    )
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                /* Trailing Text */
                trailingText?.let {
                    Text(
                        text = it,
                        style = Theme.Typography.l2,
                        fontWeight = FontWeight.Medium,
                        color = if (enabled) Theme.Mapped.Text.Inactive else Theme.Mapped.Text.Disabled
                    )
                }

                /* Barchart Icon */
                barchartIcon?.let {
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
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(2.dp)
            .background(Theme.Mapped.Surface100),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){}

}

/* sample List Item called function */
//ListItem(
//trailingIcon = DynamicImageSource.Local(R.drawable.ic_activity),
//barchartIcon = DynamicImageSource.Local(R.drawable.ic_barchart, asVector = true),
//trailingText = "1.3k",
//)

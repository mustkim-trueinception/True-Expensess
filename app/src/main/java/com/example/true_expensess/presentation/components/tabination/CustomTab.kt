package ai.truelink.app.presentation.components.tabination

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.true_expensess.presentation.components.badges.CustomBadge
import com.example.true_expensess.presentation.components.badges.CustomBadgeColorVariant
import com.example.true_expensess.presentation.components.badges.CustomBadgeColors
import com.example.true_expensess.presentation.components.badges.CustomBadgeDefaults
import com.example.true_expensess.presentation.components.image.DynamicImage
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.ImageCustomization

/**
 * Composable function that creates a custom tab row.
 *
 * This function generates a tab row with customizable appearance and behavior. It supports both fixed and scrollable
 * layouts, allowing for a flexible arrangement of tabs. Each tab can display an icon, text, and an optional badge count.
 * The tabs can be styled individually, and the entire row can be customized to have a pill shape with a surrounding border.
 *
 * - use [CustomScrollableTabRow] for a scrollable tab row.
 *
 * Example usage:
 * ```
 * CustomTabRow(
 *     selected = selectedTabIndex.value,
 *     onChange = { selectedTabIndex.value = it },
 *     tabSize = CustomTabSize.SMALL,
 *     pillShape = false,
 *     items = listOf(
 *         CustomTabItem(
 *             "Technical Info",
 *             icon = DynamicImageSource.Vector(Icons.Default.Circle),
 *             count = 5
 *         ),
 *         CustomTabItem("Tab 2"),
 *     )
 * )
 * ```
 *
 * @param modifier Modifier for styling the tab row's container.
 * @param selected The index of the currently selected tab.
 * @param onChange Callback function invoked with the index of the newly selected tab.
 * @param items A list of [CustomTabItem] representing each tab in the row.
 * @param pillShape Boolean flag to enable a pill-shaped background and border for the tab row.
 * @param colors Custom color scheme for the tab row.
 * @param tabSize Size configuration for the tabs, affecting their height and padding.
 * @param divider Optional composable to display as a divider in the tab row.
 *
 * @see CustomScrollableTabRow
 * @see CustomTabColors
 * @see CustomTabDefaults
 * @see CustomTabSize
 * @see CustomTabItem
 * @see CustomTab
 * @see CustomTabIndicator
 *
 * @author Deepak Yadu @deepak404found
 *
 */
@Composable
fun CustomTabRow(
    modifier: Modifier = Modifier,
    selected: Int,
    onChange: (Int) -> Unit,
    items: List<CustomTabItem>,
    pillShape: Boolean = true,
    colors: CustomTabColors = CustomTabDefaults.colors,
    tabSize: CustomTabSize = CustomTabSize.MEDIUM,
    divider: @Composable () -> Unit = {
        HorizontalDivider(
            color = Theme.Mapped.Shade800,
            thickness = 1.dp,
        )
    },
) {
    /* main stack */
    TabRow(
        selectedTabIndex = selected,
        containerColor = Color.Transparent,
        divider = { if (!pillShape) divider() },
        indicator = @Composable { tabPositions ->
            if (selected < tabPositions.size)
                CustomTabIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selected]),
                    indicatorColor = if (pillShape) colors.pilledIndicatorColor(
                        enabled = items[selected].enabled,
                        active = true,
                    ) else colors.indicatorColor(
                        enabled = items[selected].enabled,
                        active = true,
                    ),
                    pillShape = pillShape,
                )
        },
        modifier = modifier
            .let {
                if (pillShape)
                    it
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = Theme.Mapped.Shade900,
                            shape = CircleShape,
                        )
                        .background(Theme.Mapped.Surface600)
                        .padding(6.dp)
                else it
            },
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == selected
            val contentColor = colors.contentColor(
                enabled = item.enabled,
                active = isSelected,
            )

            CustomTab(
                props = item.copy(
                    onClick = { onChange(index) }
                ),
                contentColor = contentColor,
                tabSize = tabSize,
                pillShape = pillShape,
                modifier = item.modifier,
                badgeColors = item.badgeColors?.invoke(isSelected) ?: CustomBadgeDefaults.colors(
                    CustomBadgeColorVariant.PRIMARY
                ),
            )
        }
    }
    /* end main stack */
}

/**
 * Composable function that creates a custom scrollable tab row.
 *
 * This function generates a scrollable tab row with customizable appearance and behavior. It supports both fixed and
 * scrollable layouts, allowing for a flexible arrangement of tabs. Each tab can display an icon, text, and an optional
 * badge count. The tabs can be styled individually, and the entire row can be customized to have a pill shape with a
 * surrounding border.
 *
 * - use [CustomTabRow] for a fixed tab row.
 * - make sure to tab should have enough content to full fill the width of the screen
 *   otherwise it will not scroll and a space will be shown at the end of the tab row.
 *
 * Example usage:
 * ```
 * CustomScrollableTabRow(
 *     selected = selectedTabIndex.value,
 *     onChange = { selectedTabIndex.value = it },
 *     tabSize = CustomTabSize.SMALL,
 *     pillShape = false,
 *     edgePadding = 16.dp,
 *     items = listOf(
 *         CustomTabItem(
 *             "Technical Info",
 *             icon = DynamicImageSource.Vector(Icons.Default.Circle),
 *             count = 5,
 *         ),
 *         CustomTabItem("Tab 1"),
 *         CustomTabItem("Tab 2"),
 *         CustomTabItem("Tab 3"),
 *     )
 * )
 * ```
 *
 * @param modifier Modifier for styling the tab row's container.
 * @param selected The index of the currently selected tab.
 * @param onChange Callback function invoked with the index of the newly selected tab.
 * @param items A list of [CustomTabItem] representing each tab in the row.
 * @param pillShape Boolean flag to enable a pill-shaped background and border for the tab row.
 * @param colors Custom color scheme for the tab row.
 * @param containerColor Background color for the tab row's container.
 * @param tabSize Size configuration for the tabs, affecting their height and padding.
 * @param edgePadding Horizontal padding for the tab row's edges.
 * @param divider Optional composable to display as a divider in the tab row.
 *
 * @see CustomTabRow
 * @see CustomTabColors
 * @see CustomTabDefaults
 * @see CustomTabSize
 * @see CustomTabItem
 * @see CustomTab
 * @see CustomTabIndicator
 *
 * @author Deepak Yadu @deepak404found
 *
 */
@Composable
fun CustomScrollableTabRow(
    modifier: Modifier = Modifier,
    selected: Int,
    onChange: (Int) -> Unit,
    items: List<CustomTabItem>,
    pillShape: Boolean = true,
    colors: CustomTabColors = CustomTabDefaults.colors,
    badgeColors: CustomBadgeColors = CustomBadgeDefaults.colors(CustomBadgeColorVariant.PRIMARY),
    containerColor: Color = Theme.Mapped.Surface600,
    tabSize: CustomTabSize = CustomTabSize.MEDIUM,
    edgePadding: Dp = TabRowDefaults.ScrollableTabRowEdgeStartPadding,
    divider: @Composable () -> Unit = {
        HorizontalDivider(
            color = Theme.Mapped.Shade800,
            thickness = 1.dp,
        )
    },
) {
    /* main stack */
    ScrollableTabRow(
        selectedTabIndex = selected,
        containerColor = Color.Transparent,
        divider = { if (!pillShape) divider() },
        edgePadding = if (pillShape) 0.dp else edgePadding,
        indicator = @Composable { tabPositions ->
            if (selected < tabPositions.size)
                CustomTabIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selected]),
                    indicatorColor = if (pillShape) colors.pilledIndicatorColor(
                        enabled = items[selected].enabled,
                        active = true,
                    ) else colors.indicatorColor(
                        enabled = items[selected].enabled,
                        active = true,
                    ),
                    pillShape = pillShape,
                )
        },
        modifier = modifier
            .let {
                if (pillShape)
                    it
                        .clip(CircleShape)
                        .border(
                            width = 1.dp,
                            color = Theme.Mapped.Shade900,
                            shape = CircleShape,
                        )
                        .background(containerColor)
                        .padding(6.dp)
                else it
            }
            .background(containerColor)
            .fillMaxWidth(),
    ) {
        items.forEachIndexed { index, item ->
            val isSelected = index == selected
            val contentColor = colors.contentColor(
                enabled = item.enabled,
                active = isSelected,
            )

            CustomTab(
                props = item.copy(
                    onClick = { onChange(index) }
                ),
                contentColor = contentColor,
                tabSize = tabSize,
                pillShape = pillShape,
                scrollable = true,
                modifier = item.modifier,
                badgeColors = item.badgeColors?.invoke(isSelected) ?: CustomBadgeDefaults.colors(
                    CustomBadgeColorVariant.PRIMARY
                ),
            )
        }
    }
    /* end main stack */
}

@Composable
private fun CustomTabIndicator(
    modifier: Modifier = Modifier,
    indicatorColor: Color,
    pillShape: Boolean = false,
) {
    if (pillShape)
        Box(
            modifier = modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(
                    color = indicatorColor,
                    shape = CircleShape,
                )
                .zIndex(-1f)
        )
    else
        Box(
            modifier = modifier
                .height(2.dp)
                .background(
                    color = indicatorColor,
                ),
        )
}

@Composable
fun CustomTab(
    props: CustomTabItem,
    modifier: Modifier = Modifier,
    contentColor: Color = Theme.Mapped.Text.Active,
    badgeColors: CustomBadgeColors = CustomBadgeDefaults.colors(CustomBadgeColorVariant.PRIMARY),
    tabSize: CustomTabSize = CustomTabSize.MEDIUM,
    interactionSource: MutableInteractionSource? = null,
    scrollable: Boolean = false,
    pillShape: Boolean = false,
) {
    val dynamicProperties = CustomTabDefaults.sizeProperties(tabSize)
    val mergedStyle = LocalTextStyle.current.merge(dynamicProperties.textStyle)

    /* main stack */
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .let { if (pillShape) it.clip(CircleShape) else it }
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = props.onClick,
                enabled = props.enabled,
            )
            .height(dynamicProperties.minHeight)
            .padding(dynamicProperties.contentPadding)
    ) {
        /* container */
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides mergedStyle,
            content = {
                /* icon */
                if (props.icon != null) {
                    DynamicImage(
                        imageSource = props.icon,
                        customization = (
                                props.iconCustomization ?: ImageCustomization.Default).copy(
                            modifier = Modifier.size(
                                dynamicProperties.iconSize
                            ),
                        )
                    )
                }

                /* text */
                if (props.text != null)
                    Text(
                        text = props.text,
                        style = mergedStyle,
                        color = contentColor,
                        modifier = Modifier
                            // when scrollable, text should take all available space
                            .let { if (scrollable) it else it.weight(1f, fill = false) },
                        overflow = TextOverflow.Ellipsis,
                    )

                /* count */
                if (props.count != null)
                    CustomBadge(
                        label = props.count.toString(),
                        enabled = true,
                        size = dynamicProperties.badgeSize,
                        colors = badgeColors
                    )
            }
        )
        /* end container */
    }
    /* end main stack */
}

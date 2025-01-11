package com.example.true_expensess.presentation.screens.accounts

import ai.truelink.app.presentation.components.buttons.CustomIconButton
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant
import ai.truelink.app.presentation.components.buttons.CustomIconButtonDefaults
import ai.truelink.app.presentation.components.buttons.CustomIconButtonShape
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.true_expensess.R
import com.example.true_expensess.ui.customTheme.Theme
import kotlinx.coroutines.launch
import shortener.truelink.app.presentation.components.image.DynamicImageSource
import shortener.truelink.app.presentation.components.layouts.CompactBaseLayout
import shortener.truelink.app.presentation.components.layouts.CustomTopAppBar
import shortener.truelink.app.presentation.components.layouts.CustomTopAppBarSize

@Composable
fun Account(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(250.dp),
                drawerContainerColor = Theme.Base.Gray50
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "TrueMoney",
                        modifier = Modifier.padding(16.dp),
                        style = Theme.Typography.l1.copy(
                            fontWeight = FontWeight.SemiBold,
                            color = Theme.System.Primary600
                        )
                    )
                    HorizontalDivider(thickness = 2.dp, color = Theme.System.Primary400)

                    NavigationDrawerItem(
                        label = { Text("Preferences", color = Theme.System.Primary500) },
                        selected = false,
                        onClick = { },
                        icon = { Icon(Icons.Outlined.Settings, contentDescription = null, tint = Theme.System.Primary500) },
                    )

                    HorizontalDivider()

                    Text(
                        "Management",
                        modifier = Modifier.padding(16.dp),
                        style = Theme.Typography.l2.copy(
                            fontWeight = FontWeight.Medium,
                            color = Theme.System.Primary100
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text("Share", color = Theme.System.Primary500) },
                        selected = false,
                        onClick = { /* Handle click */ },
                        icon = { Icon(Icons.Outlined.Share, contentDescription = null, tint = Theme.System.Primary500) },
                        )
                    NavigationDrawerItem(
                        label = { Text("Export Records", color = Theme.System.Primary500) },
                        selected = false,
                        onClick = { /* Handle click */ },
                        icon = { Icon(Icons.Outlined.ExitToApp, contentDescription = null, tint = Theme.System.Primary500) },
                        )
                    NavigationDrawerItem(
                        label = { Text("Backup & Restore", color = Theme.System.Primary500) },
                        selected = false,
                        onClick = { /* Handle click */ },
                        icon = {
                            val icon: Painter = painterResource(id = R.drawable.ic_backup)
                            Image(
                                painter = icon,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp),
                                colorFilter = ColorFilter.tint(Theme.System.Primary500)
                            )
                        },
                        )
                    NavigationDrawerItem(
                        label = { Text("Delete & Reset", color = Theme.System.Primary500) },
                        selected = false,
                        onClick = { /* Handle click */ },
                        icon = { Icon(Icons.Outlined.Delete, contentDescription = null, tint = Theme.System.Primary500) },
                        )

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))


                    Text(
                        "Application",
                        modifier = Modifier.padding(16.dp),
                        style = Theme.Typography.l2.copy(
                            fontWeight = FontWeight.Medium,
                            color = Theme.System.Primary100
                        )
                    )
                    NavigationDrawerItem(
                        label = { Text("Pro Version", color = Theme.System.Primary500) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.FavoriteBorder, contentDescription = null, tint = Theme.System.Primary500) },
                        badge = { Text("20") }, // Placeholder
                        onClick = { /* Handle click */ }
                    )
                    NavigationDrawerItem(
                        label = { Text("Like TrueMoney", color = Theme.System.Primary500) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.ThumbUp, contentDescription = null, tint = Theme.System.Primary500) },
                        onClick = { /* Handle click */ },
                    )
                    NavigationDrawerItem(
                        label = { Text("Help", color = Theme.System.Primary500) },
                        selected = false,
                        badge = { Text("20") }, // Placeholder
                        onClick = { /* Handle click */ },
                        icon = {
                            val icon: Painter = painterResource(id = R.drawable.ic_help,)
                            Image(
                                painter = icon,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(24.dp),
                                colorFilter = ColorFilter.tint(Theme.System.Primary500)
                            )
                        },
                    )
                    NavigationDrawerItem(
                        label = { Text("Feedback", color = Theme.System.Primary500) },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Email, contentDescription = null, tint = Theme.System.Primary500) },
                        onClick = { /* Handle click */ },
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState,
        /* Drawer's background color */

    ) {
        CompactBaseLayout(
            topAppBar = {
                CustomTopAppBar(
                    title = "TrueMoney",
                    textStyle = Theme.Typography.l1.copy(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = Theme.System.Primary500
                    ),
                    size = CustomTopAppBarSize.Medium,
                    leading = {
                        IconButton(onClick = {
                            scope.launch {
                                if (drawerState.isClosed) {
                                    drawerState.open()
                                }
                                else {
                                    drawerState.close()
                                }
                            }
                        }) {
                            Icon(Icons.Outlined.Menu, contentDescription = "Menu", tint = Theme.Base.Dark900)
                        }
                    },
                    trailing = {
                        CustomIconButton(
                            onClick = { /* Open Drawer */ },
                            shape = CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED),
                            icon = DynamicImageSource.Vector(Icons.Default.Search),
                            colors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.INHERIT),
                            size = CustomIconButtonSize.MEDIUM,
                        )
                    }
                )
            }
        ) {  }
    }
}
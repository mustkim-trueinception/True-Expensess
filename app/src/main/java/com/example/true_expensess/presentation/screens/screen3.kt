package com.example.true_expensess.presentation.screens


import ai.truelink.app.R
import ai.truelink.app.presentation.components.images.DynamicImage
import ai.truelink.app.presentation.components.images.DynamicImageSource
import ai.truelink.app.presentation.components.images.ImageCustomization
import ai.truelink.app.ui.customTheme.Theme
import ai.truelink.app.utils.cleanNavigate
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

/* Application routes */
// Define a home route that doesn't take any arguments
@Serializable
object DashboardRoute : Route

private data class NavItemData(
    val route: Route,
    val label: String,
    val activeIcon: DynamicImageSource,
    val inactiveIcon: DynamicImageSource,
) {
    fun isSelected(currentRoute: String?) = currentRoute == route::class.qualifiedName
}

private val DashboardNavItems = listOf(
    NavItemData(
        route = DashboardRoutes.HomeRoute,
        label = "Dashboard",
        inactiveIcon = DynamicImageSource.Local(R.drawable.ic_dashboard, asVector = true),
        activeIcon = DynamicImageSource.Local(R.drawable.ic_dashboard, asVector = true),
    ),
    NavItemData(
        route = DashboardRoutes.BulkScansRoute,
        label = "Bulk Scans",
        inactiveIcon = DynamicImageSource.Local(R.drawable.ic_bulk_scan, asVector = true),
        activeIcon = DynamicImageSource.Local(R.drawable.ic_bulk_scan, asVector = true),
    ),
    NavItemData(
        route = DashboardRoutes.ThreatControlRoute,
        label = "Threat Control",
        inactiveIcon = DynamicImageSource.Local(R.drawable.ic_threat_control, asVector = true),
        activeIcon = DynamicImageSource.Local(R.drawable.ic_threat_control, asVector = true),
    ),
    NavItemData(
        route = DashboardRoutes.VpnFirewallRoute,
        label = "Firewall",
        inactiveIcon = DynamicImageSource.Local(R.drawable.ic_vpn, asVector = true),
        activeIcon = DynamicImageSource.Local(R.drawable.ic_vpn, asVector = true),
    )
)

@Composable
fun Dashboard(
    navigateTo: (Route) -> Unit = {}
) {
    val navController = rememberNavController()

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route



            Column {
                Box(modifier = Modifier.weight(1f)) {
//                    DashboardNavGraph(
//                        widthSizeClass = widthSizeClass,
//                        navHostController = navController,
//                        navigateTo = navigateTo
//                    )
                }
                DashboardBottomNavBar(currentRoute, navController)
            }

        }




@Composable
private fun DashboardBottomNavBar(
    currentRoute: String?,
    navController: NavHostController
) {
    NavigationBar(
        containerColor = Theme.Mapped.Surface800,
    ) {
        DashboardNavItems.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors().copy(
                    selectedIndicatorColor = Theme.System.Primary300.copy(alpha = 0.2f),
                ),
                selected = item.isSelected(currentRoute),
                label = {
                    Text(
                        text = item.label,
                        style = Theme.Typography.l4,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = if (item.isSelected(currentRoute)) Theme.System.Primary300 else Theme.Mapped.Text.Inactive
                    )
                },
                onClick = {

                },
                icon = {
                    DynamicImage(
                        imageSource = item.activeIcon,
                        customization = ImageCustomization(
                            tint = if (item.isSelected(currentRoute)) Theme.System.Primary300 else Theme.Mapped.Text.Inactive
                        )
                    )
                })
        }
    }
}

@Composable
private fun DashboardNavRail(
    currentRoute: String?,
    navigateTo: (Route) -> Unit = {},
) {
    NavigationRail(
        header = {
            Spacer(modifier = Modifier.height(4.dp))
        },
        containerColor = Theme.Mapped.Surface700,
    ) {
        DashboardNavItems.forEach { item ->
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            NavigationRailItem(
                colors = NavigationRailItemDefaults.colors().copy(
                    selectedIndicatorColor = Theme.System.Primary300.copy(alpha = 0.2f),
                ),
                selected = item.isSelected(currentRoute),
                onClick = {
                    navigateTo(item.route)
                },
                label = {
                    Text(
                        text = item.label,
                        style = Theme.Typography.l4,
                        color = if (item.isSelected(currentRoute)) Theme.System.Primary300 else Theme.Mapped.Text.Inactive
                    )
                },
                icon = {
                    DynamicImage(
                        imageSource = item.activeIcon,
                        customization = ImageCustomization(
                            tint = if (item.isSelected(currentRoute)) Theme.System.Primary300 else Theme.Mapped.Text.Inactive
                        )
                    )
                })
        }

    }
}
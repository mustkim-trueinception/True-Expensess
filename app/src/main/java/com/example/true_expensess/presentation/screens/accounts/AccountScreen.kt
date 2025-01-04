package com.example.true_expensess.presentation.screens.accounts

import ai.truelink.app.presentation.components.buttons.CustomIconButton
import ai.truelink.app.presentation.components.buttons.CustomIconButtonColorVariant
import ai.truelink.app.presentation.components.buttons.CustomIconButtonDefaults
import ai.truelink.app.presentation.components.buttons.CustomIconButtonShape
import ai.truelink.app.presentation.components.buttons.CustomIconButtonSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.true_expensess.R
import com.example.true_expensess.presentation.screens.accounts.components.AccountSummarySection
import com.example.true_expensess.presentation.screens.accounts.components.AddNewAccountButton
import com.example.true_expensess.presentation.screens.accounts.components.CustomCard
import com.example.true_expensess.ui.customTheme.Theme
import shortener.truelink.app.presentation.components.image.DynamicImageSource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen() {
    // Step 1: Define a data class for Account
    data class Account(
        val name: String,
        val balance: Double,
        val icon: Int // Replace with actual drawable resource ID
    )

    // Step 2: Hardcoded sample account list
    val accountsList = listOf(
        Account(name = "Card", balance = 0.0, icon = R.drawable.ic_paypal),
        Account(name = "Cash", balance = 0.0, icon = R.drawable.ic_cash),
        Account(name = "Savings", balance = 0.0, icon = R.drawable.ic_newvisa)
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MyMoney", style = Theme.Typography.l3) },
                navigationIcon = {
//                    IconButton(onClick = { /* Open Drawer */ }) {
//                        Icon(Icons.Default.Menu, contentDescription = "Menu")
//                    }
                    CustomIconButton(
                        onClick = { /* Open Drawer */ },
                        shape = CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED),
                        icon = DynamicImageSource.Vector(Icons.Default.Menu),
                        colors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.INHERIT),
                        size = CustomIconButtonSize.MEDIUM,
                    )
                },
                actions = {
//                    IconButton(onClick = { /* Search Action */ }) {
//                        Icon(Icons.Default.Search, contentDescription = "Search")
//                    }
                    CustomIconButton(
                        icon = DynamicImageSource.Vector(Icons.Default.Search),
                        onClick = { /* Search Action */ },
                        shape = CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED),
                        colors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.INHERIT),
                        size = CustomIconButtonSize.MEDIUM
                    )
                },
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primary)
            )
        },
        floatingActionButton = {
//            FloatingActionButton(onClick = { /* Add New Account Action */ }) {
//                Icon(Icons.Default.Add, contentDescription = "Add Account")
//            }
            CustomIconButton(
                onClick = { /* Add New Account Action */ },
                shape = CustomIconButtonDefaults.shape(CustomIconButtonShape.ROUNDED),
                icon = DynamicImageSource.Vector(Icons.Default.Add),
                colors = CustomIconButtonDefaults.colors(CustomIconButtonColorVariant.INHERIT),
                size = CustomIconButtonSize.MEDIUM,
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                AccountSummarySection()
            }
            item {
                AddNewAccountButton()
            }
            items(accountsList) { account ->
                CustomCard(
                    accountName = account.name,
                    balance = account.balance.toString(),
                    icon = account.icon,
                    onMoreClick = { /* Handle More Action */ }
                )
            }
        }
    }
}
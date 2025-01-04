package com.example.true_expensess.presentation.screens.accounts.components

import ai.truelink.app.ui.customTheme.Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountSummarySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "[ All Accounts ₹0.00 ]",
            style = Theme.Typography.l3
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("EXPENSE SO FAR")
                Text("₹0.00", color = Theme.Typography.color.copy(red = 0.8f), style = Theme.Typography.l3)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("INCOME SO FAR")
                Text("₹0.00", color = Theme.Typography.color.copy(green = 0.8f), style = Theme.Typography.l3)
            }
        }
    }
}

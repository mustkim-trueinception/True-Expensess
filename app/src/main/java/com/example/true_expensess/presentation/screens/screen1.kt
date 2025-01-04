package com.example.true_expensess.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


// ExpenseTrackerViewModel.kt

    private val _displayValue = MutableStateFlow("0")
    val displayValue = _displayValue.asStateFlow()

    private val _currentTab = MutableStateFlow(Tab.EXPENSE)
    val currentTab = _currentTab.asStateFlow()

    private var operator: String? = null
    private var previousValue: String? = null
    private var shouldResetDisplay = false

    fun onNumberClick(number: String) {
        _displayValue.value = when {
            shouldResetDisplay || _displayValue.value == "0" -> number
            else -> _displayValue.value + number
        }
        shouldResetDisplay = false
    }

    fun onOperatorClick(op: String) {
        operator = op
        previousValue = _displayValue.value
        shouldResetDisplay = true
    }

    fun onEqualsClick() {
        if (operator != null && previousValue != null) {
            val num1 = previousValue!!.toDouble()
            val num2 = _displayValue.value.toDouble()
            _displayValue.value = when (operator) {
                "+" -> (num1 + num2).toString()
                "-" -> (num1 - num2).toString()
                "×" -> (num1 * num2).toString()
                "÷" -> (num1 / num2).toString()
                else -> _displayValue.value
            }
            operator = null
            previousValue = null
            shouldResetDisplay = true
        }


    fun setTab(tab: Tab) {
        _currentTab.value = tab
    }
}

// ExpenseTrackerScreen.kt
@Composable
fun ExpenseTrackerScreen(
    modifier: Modifier

) {




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111827))
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = { /* TODO */ }) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color(0xFFF59E0B)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("CANCEL", color = Color(0xFFF59E0B))
                }
            }
            TextButton(onClick = { /* TODO */ }) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color(0xFFF59E0B)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("SAVE", color = Color(0xFFF59E0B))
                }
            }
        }

        // Tabs
        TabRow(
            selectedTabIndex = 0,
            containerColor = Color.Transparent,
            contentColor = Color(0xFFF59E0B)
        ) {
            Tab.values().forEach { tab ->
                Tab(
                    selected = tab == Tab.EXPENSE,
                    onClick = { },
                    text = { Text(tab.name) }
                )
            }
        }

        // Form Fields
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2937))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AccountBox, null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Account")
                }
            }
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2937))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Home, null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Category")
                }
            }
        }

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Add notes") },

        )

        // Calculator Display
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1F2937))
                .padding(16.dp)
        ) {
            Text(
                text = "",
                modifier = Modifier.align(Alignment.CenterEnd),
                fontSize = 32.sp
            )
        }

        // Calculator Keypad
        CalculatorKeypad(
            onNumberClick = {  },
            onOperatorClick = {  },
            onEqualsClick = { }
        )

        // DateTime Display
        Text(
            text = "Today, 12:00 AM",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
    }
}

@Composable
fun CalculatorKeypad(
    onNumberClick: (String) -> Unit,
    onOperatorClick: (String) -> Unit,
    onEqualsClick: () -> Unit
) {
    val buttons = listOf(
        listOf("+", "7", "8", "9"),
        listOf("-", "4", "5", "6"),
        listOf("×", "1", "2", "3"),
        listOf("÷", "0", ".", "=")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF111827))
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        buttons.forEach { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { button ->
                    Button(
                        onClick = {
                            when {
                                button in listOf("+", "-", "×", "÷") -> onOperatorClick(button)
                                button == "=" -> onEqualsClick()
                                else -> onNumberClick(button)
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(64.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when {
                                button in listOf("+", "-", "×", "÷", "=") -> Color(0xFF374151)
                                else -> Color(0xFF1F2937)
                            }
                        )
                    ) {
                        Text(button, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}

enum class Tab {
    INCOME, EXPENSE, TRANSFER
}


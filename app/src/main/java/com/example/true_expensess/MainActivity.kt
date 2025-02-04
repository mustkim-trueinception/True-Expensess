package com.example.true_expensess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.true_expensess.presentation.screens.ExpenseTrackerScreen
import com.example.true_expensess.presentation.screens.accounts.Account
import com.example.true_expensess.ui.theme.TrueExpensesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           TrueExpensesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    ExpenseTrackerScreen(modifier = Modifier.padding(innerPadding))
                    Account(modifier = Modifier.padding(innerPadding), contentPadding = PaddingValues(16.dp))
                }
            }
        }
    }}


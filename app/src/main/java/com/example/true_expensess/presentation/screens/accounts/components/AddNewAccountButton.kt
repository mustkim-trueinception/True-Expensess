package com.example.true_expensess.presentation.screens.accounts.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import shortener.truelink.app.presentation.components.buttons.CustomButton

@Composable
fun AddNewAccountButton(onClick: () -> Unit = {}) {
//    Button(
//        onClick = onClick,
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
//    ) {
//        Text("+ ADD NEW ACCOUNT")
//    }
    CustomButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        text = "+ ADD NEW ACCOUNT",
    )
}

package com.example.true_expensess.presentation.screens.records

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.true_expensess.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

//@HiltViewModel
//class MoneyViewModel @Inject constructor() : ViewModel() {
//    private val _currentDate = MutableStateFlow(Calendar.getInstance())
//    val currentDate: StateFlow<Calendar> = _currentDate
//
//    private val _expense = MutableStateFlow(0.0)
//    val expense: StateFlow<Double> = _expense
//
//    private val _income = MutableStateFlow(0.0)
//    val income: StateFlow<Double> = _income
//
//    fun nextMonth() {
//        _currentDate.value.add(Calendar.MONTH, 1)
//        _currentDate.value = _currentDate.value
//    }
//
//    fun previousMonth() {
//        _currentDate.value.add(Calendar.MONTH, -1)
//        _currentDate.value = _currentDate.value
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoneyApp() {
//    val currentDate by viewModel.currentDate.collectAsState()
//    val expense by viewModel.expense.collectAsState()
//    val income by viewModel.income.collectAsState()

    val dancingScript = FontFamily(
        Font(R.font.inter_semi_bold)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "MyMoney",
                        fontFamily = dancingScript,
                        fontSize = 24.sp,
                        color = Color(0xFFFFF9C4)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color(0xFFFFF9C4)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color(0xFFFFF9C4)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF424242)
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF424242),
                modifier = Modifier.navigationBarsPadding()
            ) {
                listOf(
                    Triple("Records", Icons.Default.List, true),
                    Triple("Analysis", Icons.Default.AccountBox, false),
                    Triple("Budgets", Icons.Default.Star, false),
                    Triple("Accounts", Icons.Default.ShoppingCart, false),
                    Triple("Categories", Icons.Default.ArrowDropDown, false)
                ).forEach { (title, icon, selected) ->
                    NavigationBarItem(
                        icon = { Icon(icon, contentDescription = title) },
                        label = { Text(title) },
                        selected = selected,
                        onClick = { },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.LightGray,
                            selectedTextColor = Color.LightGray,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = Color(0xFF757575),
                contentColor = Color(0xFFFFF9C4)
            ) {
                Icon(Icons.Default.Add, "Add transaction")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
//            MonthSelector(
//                currentDate = currentDate,
//                onPreviousMonth = { viewModel.previousMonth() },
//                onNextMonth = { viewModel.nextMonth() }
//            )

//            Summary(expense = expense, income = income)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF616161)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.List,
                        contentDescription = null,
                        modifier = Modifier.size(64.dp),
                        tint = Color(0xFFFFF9C4)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "No record in this month. Tap + to add new expense or income.",
                        color = Color(0xFFFFF9C4)
                    )
                }
            }
        }
    }
}

@Composable
fun MonthSelector(
    currentDate: Calendar,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF424242))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onPreviousMonth) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Previous month",
                tint = Color(0xFFFFF9C4)
            )
        }
        Text(
            SimpleDateFormat("MMMM, yyyy", Locale.getDefault()).format(currentDate.time),
            color = Color(0xFFFFF9C4)
        )
        IconButton(onClick = onNextMonth) {
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Next month",
                tint = Color(0xFFFFF9C4)
            )
        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.List,
                contentDescription = "Filter",
                tint = Color(0xFFFFF9C4)
            )
        }
    }
}

@Composable
fun Summary(expense: Double, income: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF424242))
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SummaryItem("EXPENSE", expense, Color(0xFFEF5350))
        SummaryItem("INCOME", income, Color(0xFF66BB6A))
        SummaryItem("TOTAL", income - expense, if (income >= expense) Color(0xFF66BB6A) else Color(0xFFEF5350))
    }
}

@Composable
fun SummaryItem(label: String, amount: Double, amountColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            label,
            color = Color.Gray,
            fontSize = 12.sp
        )
        Text(
            "₹%.2f".format(amount),
            color = amountColor
        )
    }
}

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//    @Provides
//    @Singleton
//    fun provideApplication(): Application {
//        return Application()
//    }
//}
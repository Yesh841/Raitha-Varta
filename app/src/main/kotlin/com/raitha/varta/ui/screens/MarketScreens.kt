package com.raitha.varta.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raitha.varta.ui.theme.GreenPrimary

@Composable
fun ExpertAskScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }, containerColor = GreenPrimary) {
                Icon(Icons.Default.Add, contentDescription = "New Query", tint = Color.White)
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Ask our Experts", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GreenPrimary)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Get personalized advice for your farm problems.", fontSize = 16.sp, color = Color.Gray)
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // List of previous queries
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Paddy seeds turn brown", fontWeight = FontWeight.Bold)
                    Text("Status: Answered", color = Color(0xFF2E7D32), fontSize = 12.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Response: This looks like a nutrient deficiency. Add Zinc Sulfate...")
                }
            }
        }
    }
}

@Composable
fun MarketplaceScreen(navController: NavController) {
    val items = listOf("Organic Seeds", "Tractor for Rent", "Fertilizers", "Fresh Paddy 500kg")
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Marketplace", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GreenPrimary)
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(items) { item ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            Text(item, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            Text("Location: Sirsi, Karnataka", fontSize = 14.sp)
                        }
                        Text("₹ 2,000", color = GreenPrimary, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

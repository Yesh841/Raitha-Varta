package com.raitha.varta.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raitha.varta.ui.theme.GreenPrimary

@Composable
fun WeatherScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)) {
            Text("Raitha-Varta", fontWeight = FontWeight.Black, fontSize = 36.sp, color = GreenDark)
            Text("Farmer's Voice • ರೈತರ ಧ್ವನಿ", fontWeight = FontWeight.Bold, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        Surface(
            color = Color(0xFFFFD54F),
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.padding(32.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text("31°C", fontSize = 48.sp, fontWeight = FontWeight.Black)
                    Text("Hassan, KA • Sunny", fontWeight = FontWeight.Bold, opacity = 0.8f)
                }
                Icon(Icons.Default.WbSunny, contentDescription = null, modifier = Modifier.size(64.dp))
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Card(modifier = Modifier.weight(1f).height(120.dp), shape = RoundedCornerShape(24.dp)) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
                    Text("SOIL HEALTH", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                    Text("8.4 (Optimal)", fontSize = 18.sp, fontWeight = FontWeight.Black)
                }
            }
            Card(modifier = Modifier.weight(1f).height(120.dp), shape = RoundedCornerShape(24.dp)) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.Center) {
                    Text("RAIN FORECAST", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
                    Text("0% Chance", fontSize = 18.sp, fontWeight = FontWeight.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth().weight(1f),
            shape = RoundedCornerShape(32.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("MANDI PRICES • ಮಾರುಕಟ್ಟೆ", fontWeight = FontWeight.Bold, fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                MandiRow("Paddy (Grade A)", "₹2,250 / q")
                MandiRow("Coconut (Big)", "₹18,500 / 1k")
                MandiRow("Areca Nut", "₹48,200 / q")
                MandiRow("Tomato", "₹1,400 / q")
                
                Spacer(modifier = Modifier.weight(1f))
                Surface(color = Color(0xFFF5F5F5), shape = RoundedCornerShape(12.dp)) {
                    Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                        Text("💡", fontSize = 24.sp)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("Apply Nitrogen fertilizer before sunset.", fontSize = 13.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun MandiRow(item: String, price: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(item)
        Text(price, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun SuccessStoriesScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Farmer Success Stories", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = GreenPrimary)
        Spacer(modifier = Modifier.height(16.dp))
        
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Bheemappa's 3x Yield", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("Sirsi, Karnataka")
                Spacer(modifier = Modifier.height(12.dp))
                Text("By following the coconut root feeding tips from Raitha Varta, I was able to increase my yield from 4000 to 12000 nuts per year.")
            }
        }
    }
}

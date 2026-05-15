package com.raitha.varta.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raitha.varta.ui.theme.GreenPrimary

@Composable
fun LanguageSelectScreen(navController: NavController) {
    val languages = listOf("English", "ಕನ್ನಡ (Kannada)", "हिन्दी (Hindi)", "தமிழ் (Tamil)")
    
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Select Your Language", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = GreenPrimary)
        Spacer(modifier = Modifier.height(32.dp))
        
        languages.forEach { lang ->
            Button(
                onClick = { navController.navigate("home") },
                modifier = Modifier.fillMaxWidth().height(56.dp).padding(vertical = 4.dp)
            ) {
                Text(lang, fontSize = 18.sp)
            }
        }
    }
}

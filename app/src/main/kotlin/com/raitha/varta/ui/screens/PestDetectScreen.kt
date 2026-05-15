package com.raitha.varta.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.raitha.varta.ui.theme.GreenPrimary

@Composable
fun PestDetectScreen(navController: NavController) {
    var isAnalyzing by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "AI Pest Detection",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = GreenPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Take a clear photo of the infected leaf to diagnose disease.",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(48.dp))

        Box(
            modifier = Modifier
                .size(300.dp)
                .background(Color.LightGray, RoundedCornerShape(24.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.CameraAlt, contentDescription = null, size = 100.dp, tint = Color.Gray)
        }

        Spacer(modifier = Modifier.height(48.dp))

        if (isAnalyzing) {
            CircularProgressIndicator(color = GreenPrimary)
            Text("AI is analyzing the leaf...", modifier = Modifier.padding(16.dp))
        } else if (result != null) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Diagnosis Result:", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(result!!, fontSize = 16.sp)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { result = null }, modifier = Modifier.fillMaxWidth()) {
                Text("Scan Another Leaf")
            }
        } else {
            Button(
                onClick = { 
                    isAnalyzing = true
                    // Simulate API call to backend
                    // In real app, we'd capture image and send to /api/disease/detect
                },
                modifier = Modifier.fillMaxWidth().height(64.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.CameraAlt, contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
                Text("Capture & Scan", fontSize = 20.sp)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            OutlinedButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(64.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Default.PhotoLibrary, contentDescription = null)
                Spacer(modifier = Modifier.width(12.dp))
                Text("Pick from Gallery", fontSize = 20.sp)
            }
        }
    }

    LaunchedEffect(isAnalyzing) {
        if (isAnalyzing) {
            kotlinx.coroutines.delay(3000)
            isAnalyzing = false
            result = "Disease: Leaf Blast (ಬೆಂಕಿ ರೋಗ)\nSeverity: Moderate\nTreatment: Spray Tricyclazole 75 WP at 0.6g/liter of water. Maintain proper drainage in the field."
        }
    }
}

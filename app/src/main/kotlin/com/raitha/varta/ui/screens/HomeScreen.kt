package com.raitha.varta.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.raitha.varta.R
import com.raitha.varta.domain.model.Tip
import com.raitha.varta.ui.theme.GreenBorder
import com.raitha.varta.ui.theme.GreenDark
import com.raitha.varta.ui.theme.GreenLight
import com.raitha.varta.ui.theme.GreenPrimary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val sampleTips = listOf(
        Tip("1", "Paddy • ಭತ್ತ", "Water Management", "Ensure 2-3cm of standing water during the tillering stage. Stop irrigation 10 days before harvest.", "https://images.unsplash.com/photo-1590401075989-49e88cff9b63?q=80&w=400", "en"),
        Tip("2", "Coconut • ತೆಂಗು", "Root Feeding", "Mix 2g Urea + 2g Potash in 1L water for root feeding every 6 months for better nut size.", "https://images.unsplash.com/photo-1550596334-7bb40a71b6bc?q=80&w=400", "en"),
        Tip("3", "Areca Nut • ಅಡಿಕೆ", "Disease Control", "Control Koleroga using 1% Bordeaux mixture before monsoon. Repeat after 40 days.", "https://images.unsplash.com/photo-1589133415531-1ee0662d5125?q=80&w=400", "en")
    )

    val pagerState = rememberPagerState(pageCount = { sampleTips.size })

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                    label = { Text("Home", color = Color.White) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("expert_ask") },
                    icon = { Icon(Icons.Default.QuestionAnswer, contentDescription = "Ask", tint = Color.White) },
                    label = { Text("Expert", color = Color.White) }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { navController.navigate("marketplace") },
                    icon = { Icon(Icons.Default.Storefront, contentDescription = "Market", tint = Color.White) },
                    label = { Text("Market", color = Color.White) }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = stringResource(id = R.string.welcome_message),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                color = GreenPrimary
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 32.dp),
                pageSpacing = 16.dp
            ) { page ->
                TipCard(tip = sampleTips[page])
            }
        }
    }
}

@Composable
fun TipCard(tip: Tip) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.85f),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = androidx.compose.foundation.BorderStroke(2.dp, GreenBorder),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.weight(0.55f)) {
                AsyncImage(
                    model = tip.imageUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                
                IconButton(
                    onClick = { /* TTS */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(50))
                        .size(40.dp)
                ) {
                    Icon(Icons.Default.VolumeUp, contentDescription = "Listen", tint = GreenPrimary)
                }
            }

            Column(
                modifier = Modifier
                    .weight(0.45f)
                    .padding(24.dp)
            ) {
                Surface(
                    color = GreenLight,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = tip.cropId,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Black,
                        color = GreenDark
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Text(
                    text = tip.title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = HighContrastBlack,
                    lineHeight = 28.sp
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Text(
                    text = tip.description,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    color = Color.DarkGray
                )
                
                Spacer(modifier = Modifier.weight(1f))
                
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = GreenPrimary),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Default.Share, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Share With Farmers", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

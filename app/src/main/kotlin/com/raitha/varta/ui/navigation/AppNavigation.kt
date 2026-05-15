package com.raitha.varta.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.raitha.varta.ui.screens.*

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object LanguageSelect : Screen("language_select")
    object Home : Screen("home")
    object ExpertAsk : Screen("expert_ask")
    object Marketplace : Screen("marketplace")
    object PestDetect : Screen("pest_detect")
    object SuccessStories : Screen("stories")
    object Weather : Screen("weather")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            SplashScreen(onFinished = {
                navController.navigate(Screen.LanguageSelect.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }
        composable(Screen.LanguageSelect.route) { LanguageSelectScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.ExpertAsk.route) { ExpertAskScreen(navController) }
        composable(Screen.Marketplace.route) { MarketplaceScreen(navController) }
        composable(Screen.PestDetect.route) { PestDetectScreen(navController) }
        composable(Screen.SuccessStories.route) { SuccessStoriesScreen(navController) }
        composable(Screen.Weather.route) { WeatherScreen(navController) }
    }
}

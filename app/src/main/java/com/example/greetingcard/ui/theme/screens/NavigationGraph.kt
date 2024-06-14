package com.example.greetingcard.ui.theme.screens

import WelcomeScreen
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.greetingcard.viewmodels.VendorViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationGraph(viewModel: VendorViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN) {
        composable(Routes.WELCOME_SCREEN) {
            WelcomeScreen(viewModel, navController)
        }

        composable(Routes.VENDOR_INFO_SCREEN) {
            VendorInfoScreen(viewModel, navController)
        }
    }
}



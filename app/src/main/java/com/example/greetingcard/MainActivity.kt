package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.greetingcard.ui.theme.GreetingCardTheme
import com.example.greetingcard.ui.theme.screens.NavigationGraph
import com.example.greetingcard.viewmodels.VendorViewModel

class MainActivity : ComponentActivity() {
    private val myViewModel: VendorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                NavigationGraph(myViewModel)
            }
        }
    }
}




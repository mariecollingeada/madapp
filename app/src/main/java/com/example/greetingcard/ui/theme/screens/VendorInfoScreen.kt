package com.example.greetingcard.ui.theme.screens


import Header
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.example.greetingcard.models.Vendor
import com.example.greetingcard.viewmodels.VendorViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendorInfoScreen(viewModel: VendorViewModel, navController: NavHostController) {
    val selectedVendor by viewModel.selectedVendor.observeAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
//                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Header(modifier = Modifier.padding())
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
    )
    { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Vendor info page" 
            )
            selectedVendor?.title?.let { Text(text = it) }
            Button(onClick = { navController.navigate(Routes.WELCOME_SCREEN) }) {
                Text(text = "Back")
            }

        }
    }
}


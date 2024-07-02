package com.example.greetingcard.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.wear.compose.material3.ripple
import com.example.greetingcard.R
import com.example.greetingcard.models.Vendor
import com.example.greetingcard.ui.theme.screens.Routes
import com.example.greetingcard.viewmodels.VendorViewModel


@Composable
fun VendorResults(viewModel: VendorViewModel, navController: NavHostController) {
    val vendors by viewModel.vendors.observeAsState(emptyList())
    LazyColumn (contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp)) {
        items(vendors) {
                vendor ->
            VendorCard(vendor = vendor) {
                viewModel.setSelectedVendor(vendor)
                navController.navigate(Routes.VENDOR_INFO_SCREEN)
            }
        }
    }
    DisposableEffect(Unit) {
        viewModel.getVendors()
        onDispose {}
    }
}

@Composable
fun VendorCard(vendor: Vendor, onClick: (Int) -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(),
                onClick = {onClick(vendor.id)}
            )
    ) {
        Image(painter = painterResource(id = R.drawable.little), contentDescription = null)
        Text(
            text = vendor.title,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
        Text(text = vendor.shortDesc, modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center)
    }
}


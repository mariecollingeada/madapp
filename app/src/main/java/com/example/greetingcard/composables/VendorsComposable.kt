package com.example.greetingcard.composables

import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.greetingcard.R
import com.example.greetingcard.models.Vendor
import com.example.greetingcard.viewmodels.VendorViewModel


@Composable
fun VendorList(viewModel: VendorViewModel) {
    val vendors by viewModel.vendors.observeAsState(emptyList())
    LazyColumn (contentPadding = PaddingValues(horizontal = 24.dp, vertical = 24.dp)) {
        items(vendors) {
                vendor ->
            VendorCard(vendor)
        }
    }
    DisposableEffect(Unit) {
        viewModel.getVendors()
        onDispose {}
    }
}

@Composable
fun VendorCard(vendor: Vendor) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
//            .size(width = 100.dp, height = 100.dp)
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


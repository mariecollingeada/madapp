package com.example.greetingcard.composables

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.greetingcard.viewmodels.VendorViewModel

@Composable
fun FilterList(viewModel: VendorViewModel) {
    LazyRow {
        item { VendorFilter(type = "VENUE", onFilterSelected = viewModel::setSelectedFilter) }
        item { VendorFilter(type = "DECORATOR", onFilterSelected = viewModel::setSelectedFilter) }
        item { VendorFilter(type = "CATERER", onFilterSelected = viewModel::setSelectedFilter) }
        item { VendorFilter(type = "MISC", onFilterSelected = viewModel::setSelectedFilter) }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VendorFilter(type: String, onFilterSelected: (String) -> Unit) {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        onClick = { selected = !selected
            if (selected) {
                onFilterSelected(type)
            } else {
                onFilterSelected("") // Deselecting, passing an empty filter
            }
                  },
        label = {
            Text(text = type)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

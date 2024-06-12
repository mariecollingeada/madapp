package com.example.greetingcard.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.greetingcard.viewmodels.VendorViewModel

@ExperimentalMaterial3Api
@Composable
fun SearchBar( viewModel: VendorViewModel,
    modifier: Modifier = Modifier,
    hint: String = "Search...",
    onSearch: (String) -> Unit,
    icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Default.Search,
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black
) {
    val query by remember { mutableStateOf(TextFieldValue) }

    Row(modifier = modifier.fillMaxWidth()) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.padding(8.dp)
        )
        BasicTextField(
            value = query,
            onValueChange = { newValue ->
                // Invoke the search callback with the new value
                onSearch(newValue.text)
            },
            singleLine = true,
            textStyle = MaterialTheme.typography.bodySmall.copy(color = contentColor),
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            cursorBrush = SolidColor(contentColor),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                ) {
                    innerTextField()
                }
            }
        )
    }
}
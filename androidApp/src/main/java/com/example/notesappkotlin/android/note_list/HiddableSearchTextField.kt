package com.example.notesappkotlin.android.note_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HiddableSearchTextField(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    onCloseClick: () -> Unit,
    isSearchActive: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AnimatedVisibility(visible = isSearchActive, enter = fadeIn(), exit = fadeOut()){
            OutlinedTextField(
                value = text,
                onValueChange = onTextChange,
                shape = RoundedCornerShape(50.dp),
                placeholder = { Text(text = "Search")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(end = 40.dp),
            )
        }
        AnimatedVisibility(visible = isSearchActive, enter = fadeIn(), exit = fadeOut(), modifier = Modifier.align(Alignment.CenterEnd)) {
            IconButton(onClick = onCloseClick) {
                Icon(imageVector = Icons.Filled.Close, contentDescription = "Close Icon")
            }
        }
        AnimatedVisibility(visible = !isSearchActive, enter = fadeIn(), exit = fadeOut(), modifier = Modifier.align(Alignment.CenterEnd)) {
            IconButton(onClick = onSearchClick) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon")
            }
        }
    }
}

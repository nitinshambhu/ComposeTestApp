package com.test.compose.common

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopBar(title: String, navIcon : ImageVector, contentDesc: String, onNavIconClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = { onNavIconClicked() }) {
                Icon(navIcon, contentDescription = contentDesc)
            }

        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}
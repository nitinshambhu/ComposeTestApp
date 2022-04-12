package com.test.compose.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(
    title: String,
    navIcon: ImageVector,
    contentDesc: String,
    onNavIconClicked: () -> Unit
) {
    BottomAppBar(
        content = {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { onNavIconClicked() }) {
                    Icon(navIcon, contentDescription = contentDesc)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = title, style = MaterialTheme.typography.button)
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant
    )
}
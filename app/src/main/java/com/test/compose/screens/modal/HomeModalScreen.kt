package com.test.compose.screens.modal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.test.compose.common.TopBar
import com.test.compose.ui.theme.ComposeTestAppTheme

@Composable
fun  HomeModalScreen(onNavIconClicked: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        TopBar(title = "Home Modal Screen", navIcon = Icons.Filled.Menu, contentDesc = "Home Modal Screen Menu", onNavIconClicked)
        Text(text = "Home Screen", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultHomeModalScreenPreview() {
    ComposeTestAppTheme {
        HomeModalScreen {}
    }
}
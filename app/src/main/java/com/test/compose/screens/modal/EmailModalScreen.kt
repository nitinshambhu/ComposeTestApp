package com.test.compose.screens.modal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.test.compose.common.TopBar
import com.test.compose.ui.theme.ComposeTestAppTheme

@Composable
fun EmailModalScreen(onNavIconClicked: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        TopBar(title = "Email Modal Screen", navIcon = Icons.Filled.ArrowBack, contentDesc = "Email Modal Screen Menu", onNavIconClicked)
        Text(text = "Email Screen", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultEmailModalScreenPreview() {
    ComposeTestAppTheme {
        EmailModalScreen {}
    }
}
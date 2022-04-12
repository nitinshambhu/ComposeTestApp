package com.test.compose.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.compose.common.DrawerItem
import com.test.compose.common.TopBar
import com.test.compose.common.TopDrawerContent
import com.test.compose.ui.theme.ComposeTestAppTheme
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val isOpen = scaffoldState.drawerState.isOpen

    Scaffold(
        Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            TopBar("Top title", navIcon = Icons.Filled.Menu, "Open Navigation Drawer") {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerContent = {
            TopDrawerContent(listOfDrawerItems) {
                scope.launch {
                    scaffoldState.drawerState.close()
                    scaffoldState.snackbarHostState.showSnackbar(it)
                }
            }
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isClosed,
        drawerElevation = 8.dp,

        ) {
        PaddingValues(16.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTestAppTheme {
        ScaffoldScreen()
    }
}

private val listOfDrawerItems = listOf(
    DrawerItem(
        title = "Home",
        icon = Icons.Outlined.Home,
        subTitle = "Home Screen"
    ),
    DrawerItem(
        title = "Calls",
        icon = Icons.Outlined.Call,
        subTitle = "Call history"
    ),
    DrawerItem(
        title = "Emails",
        icon = Icons.Filled.Email,
        subTitle = "Email Inbox"
    ),
)




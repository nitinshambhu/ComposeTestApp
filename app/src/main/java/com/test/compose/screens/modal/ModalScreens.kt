package com.test.compose.screens.modal

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.test.compose.common.DrawerItem
import com.test.compose.common.TopDrawerContent
import com.test.compose.ui.theme.ComposeTestAppTheme
import kotlinx.coroutines.launch

@Composable
fun ModalScreens() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navHostController = rememberNavController()
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerContent = {
            TopDrawerContent(drawerItems = listOfDrawerItems) { route ->
                navHostController.navigate(route)
                scope.launch { drawerState.close() }
            }
        },
        modifier = Modifier.fillMaxWidth(),
        drawerElevation = 2.dp,
        drawerState = drawerState,
        drawerBackgroundColor = MaterialTheme.colors.background
    ) {
        ModalScreensNavigation(navHostController = navHostController, drawerState = drawerState)
    }

}

private val listOfDrawerItems = listOf(
    DrawerItem(
        title = "Home",
        icon = Icons.Outlined.Home,
        subTitle = "Home Screen",
        route = ModalScreen.Home.route
    ),
    DrawerItem(
        title = "Calls",
        icon = Icons.Outlined.Call,
        subTitle = "Call history",
        route = ModalScreen.Call.route
    ),
    DrawerItem(
        title = "Emails",
        icon = Icons.Outlined.Email,
        subTitle = "Email Inbox",
        route = ModalScreen.Email.route
    ),
)

@Preview(showBackground = true)
@Composable
fun DefaultModelScreensPreview() {
    ComposeTestAppTheme {
        ModalScreens()
    }
}

sealed class ModalScreen(val route: String) {
    object Home : ModalScreen("/home")
    object Call : ModalScreen("/call")
    object Email : ModalScreen("/email")
}
package com.test.compose.common

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.test.compose.screens.modal.ModalScreen

@Composable
fun TopDrawerContent(
    drawerItems: List<DrawerItem>,
    onDrawerItemClicked: (String) -> Unit
) {
    Log.e("TINTIN", "TopDrawerContent()....")
    val selectedRoute = remember { mutableStateOf(ModalScreen.Home.route) }
    drawerItems.forEachIndexed { index, drawerItem ->
        DrawerListItem(
            drawerItem = drawerItem,
            selectedRoute = selectedRoute,
            showDivider = drawerItems.size > 1 && index % 2 == 0,
        ) { route ->
            selectedRoute.value = route
            onDrawerItemClicked.invoke(route)
        }
    }
}

@Composable
private fun DrawerListItem(
    drawerItem: DrawerItem,
    selectedRoute: MutableState<String>,
    showDivider: Boolean = false,
    onDrawerItemClicked: (String) -> Unit
) {
    Log.e("TINTIN", "DrawerListItem()....")
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    selectedRoute.value = drawerItem.route
                    onDrawerItemClicked.invoke(drawerItem.route)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            val tintColor =
                if (selectedRoute.value == drawerItem.route)
                    MaterialTheme.colors.primary else Color.Black

            if (drawerItem.icon != null) {
                Icon(
                    imageVector = drawerItem.icon,
                    contentDescription = "Localized description",
                    tint = tintColor
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = drawerItem.title, style = TextStyle(
                        color = tintColor,
                        fontSize = MaterialTheme.typography.h3.fontSize
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = drawerItem.subTitle, style = TextStyle(
                        color = tintColor,
                        fontSize = MaterialTheme.typography.subtitle1.fontSize
                    )
                )
            }

        }
        if (showDivider) Divider()
    }
}

data class DrawerItem(
    val title: String,
    val icon: ImageVector? = null,
    val subTitle: String = "",
    val route: String = ""
)
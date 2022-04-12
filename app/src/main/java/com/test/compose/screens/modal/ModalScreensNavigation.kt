package com.test.compose.screens.modal

import androidx.compose.material.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch

@Composable
fun ModalScreensNavigation(navHostController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    NavHost(navController = navHostController, startDestination = ModalScreen.Home.route) {
        composable(route = ModalScreen.Home.route) {
            HomeModalScreen {
                scope.launch {
                    drawerState.open()
                }
            }
        }
        composable(route = ModalScreen.Call.route) {
            CallModalScreen {
                scope.launch {
                    drawerState.open()
                }
            }
        }
        composable(route = ModalScreen.Email.route) {
            EmailModalScreen {
                scope.launch {
                    navHostController.popBackStack(route = ModalScreen.Home.route, inclusive = false)
                }
            }
        }
    }
}
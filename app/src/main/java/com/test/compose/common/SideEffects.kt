package com.test.compose.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.CoroutineScope


@Composable
fun LaunchOnlyOnce(block: CoroutineScope.() -> Unit) {
    LaunchedEffect(key1 = Unit) {
        block.invoke(this)
    }
}
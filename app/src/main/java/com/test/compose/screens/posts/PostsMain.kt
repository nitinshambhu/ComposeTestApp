package com.test.compose.screens.posts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostsMain(viewModel: PostsViewModel = koinViewModel()) {
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchPosts()
    }
    PostsScreen()
}
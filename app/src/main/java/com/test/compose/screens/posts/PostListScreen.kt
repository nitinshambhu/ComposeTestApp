package com.test.compose.screens.posts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable

@Composable
fun PostListScreen(posts: List<Post>) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        items(posts, key = { it.id }) { item: Post ->
            PostItem(post = item)
        }
    }
}
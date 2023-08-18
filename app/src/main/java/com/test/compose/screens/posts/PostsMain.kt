package com.test.compose.screens.posts

import ErrorScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.test.compose.common.LaunchOnlyOnce
import com.test.compose.common.LoadingScreen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostsMain(viewModel: PostsViewModel = koinViewModel()) {
    val state by viewModel.collectUIState()

    LaunchOnlyOnce {
        launch {
//            viewModel.collectSideEffect {}
        }
        viewModel.fetchPosts()
    }

    Log.e("TINTIN", "state = $state")
    when  {
        state.isLoading -> LoadingScreen(state.loadingMessage)
        state.errorMessage.isNotBlank() -> ErrorScreen(state.errorMessage)
        else -> PostListScreen(state.posts)
    }
}
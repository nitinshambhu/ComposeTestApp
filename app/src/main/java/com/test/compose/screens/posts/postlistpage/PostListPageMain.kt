package com.test.compose.screens.posts.postlistpage

import ErrorScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.test.compose.common.LaunchOnlyOnce
import com.test.compose.common.LoadingScreen
import com.test.compose.common.PageState
import com.test.compose.screens.posts.PostListScreen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun PostListPageMain(viewModel: PostListPageViewModel = koinViewModel()) {
    val state : PageState<PostListPageComposeContract.UiState> by viewModel.collectUIState()

    LaunchOnlyOnce {
        launch {
//            viewModel.collectSideEffect {}
        }
        viewModel.fetchPosts()
    }
    Log.e("TINTIN", "state = $state")
    when (val screenState = state) {
        is PageState.Loading -> LoadingScreen(screenState.message)
        is PageState.Loaded -> PostListScreen(screenState.uiState.posts)
        is PageState.Error -> ErrorScreen(screenState.error)
    }
}
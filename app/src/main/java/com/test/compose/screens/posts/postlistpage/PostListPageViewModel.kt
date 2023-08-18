package com.test.compose.screens.posts.postlistpage

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.compose.common.PageState
import com.test.compose.common.ScreenState
import com.test.compose.screens.posts.PostsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostListPageViewModel(private val repo: PostsRepo) : ViewModel(), PostListPageComposeContract {

    override val _pageState: MutableStateFlow<PageState<PostListPageComposeContract.UiState>> =
        MutableStateFlow(PageState.Loading())

    override var _uiState: PostListPageComposeContract.UiState =
        PostListPageComposeContract.UiState()

    fun fetchPosts() {
        Log.i("TINTIN", "Fetching Posts")
        viewModelScope.launch {
            val posts = repo.fetchPosts().getOrElse {
                Log.e("TINTIN", "Failed to fetch post", it)
                return@launch
            }
            Log.i("TINTIN", "Fetching Posts... done")
            showUIPage { copy(posts = posts) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        repo.clear()
    }

}
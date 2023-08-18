package com.test.compose.screens.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.compose.common.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class
PostsViewModel(private val repo: PostsRepo) : ViewModel(), PostsContract {

    override val _uiState: MutableStateFlow<PostsContract.UiState> =
        MutableStateFlow(initialState())

    override fun initialState(): PostsContract.UiState {
        return PostsContract.UiState()
    }

    fun fetchPosts() {
        Log.i("TINTIN", "Fetching Posts")
        viewModelScope.launch {
            val posts = repo.fetchPosts().getOrElse {
                Log.e("TINTIN", "Failed to fetch post", it)
                updateUiState { copy(isLoading = false, errorMessage = "Failed to fetch posts") }
                return@launch
            }
            Log.i("TINTIN", "Fetching Posts... done")
            updateUiState {
                copy(posts = posts, isLoading = false, errorMessage = "")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        repo.clear()
    }

}
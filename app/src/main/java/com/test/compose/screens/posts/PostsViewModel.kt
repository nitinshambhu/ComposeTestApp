package com.test.compose.screens.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostsViewModel(private val repo: PostsRepo) : ViewModel(), PostsContract {

    override fun initialState(): PostsContract.UiState {
        return PostsContract.UiState()
    }

    fun fetchPosts() {
        viewModelScope.launch {
            val posts = repo.fetchPosts().getOrElse {
                Log.e("TINTIN", "Failed to fetch post", it)
                return@launch
            }
            updateUiState { copy(list = posts) }
        }
    }

    override fun onCleared() {
        super.onCleared()
        repo.clear()
    }

}
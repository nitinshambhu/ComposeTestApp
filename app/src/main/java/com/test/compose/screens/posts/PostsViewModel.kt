package com.test.compose.screens.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PostsViewModel(private val repo: PostsRepo) : ViewModel() {
    fun fetchPosts() {
        viewModelScope.launch {
            repo.fetchPosts()
                .onSuccess {

                }
                .onFailure {
                    Log.e("TINTIN", "Failed to fetch post", it)
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
        repo.clear()
    }

}
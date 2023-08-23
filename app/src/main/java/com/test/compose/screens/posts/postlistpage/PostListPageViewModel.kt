package com.test.compose.screens.posts.postlistpage

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.test.compose.screens.posts.PostsRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PostListPageViewModel(private val repo: PostsRepo) : PostListPageComposeContract() {

    fun fetchPosts() {
        Log.i("TINTIN", "Fetching Posts")
        viewModelScope.launch {
            delay(5000)
            showLoadingPage(message = "Connecting to server")
            delay(5000)
            val posts = repo.fetchPosts().getOrElse {
                Log.e("TINTIN", "Failed to fetch post", it)
                showErrorPage(errorMessage = it.message ?: "Failed to fetch data")
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
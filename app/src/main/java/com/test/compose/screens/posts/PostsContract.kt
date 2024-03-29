package com.test.compose.screens.posts

import com.test.compose.common.ComposeContract

interface PostsContract : ComposeContract<PostsContract.UiState, PostsContract.Effect> {

    data class UiState(
        val posts: List<Post> = emptyList(),
        val isLoading: Boolean = true,
        val loadingMessage: String = "Loading please wait...",
        val errorMessage: String = ""
    )

    sealed class Effect {
        object OnBackPressed : Effect()
        data class ShowToast(val message: String) : Effect()
        data class showDialog(val title: String, val msg: String): Effect()
    }
}
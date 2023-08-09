package com.test.compose.screens.posts

import com.test.compose.common.ComposeContract

interface PostsContract : ComposeContract<PostsContract.UiState, PostsContract.Effect> {

    data class UiState(
        val list: List<Int> = emptyList()
    )

    sealed class Effect {
        object OnBackPressed : Effect()
        data class ShowToast(val message: String) : Effect()
    }
}
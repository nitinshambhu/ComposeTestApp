package com.test.compose.screens.posts.postlistpage

import com.test.compose.common.ComposePageContract
import com.test.compose.screens.posts.Post

interface PostListPageComposeContract :
    ComposePageContract<PostListPageComposeContract.UiState, PostListPageComposeContract.Effect> {

    data class UiState(
        val posts: List<Post> = emptyList()
    )

    sealed class Effect {
        object OnBackPressed : Effect()
        data class ShowToast(val message: String) : Effect()
    }
}
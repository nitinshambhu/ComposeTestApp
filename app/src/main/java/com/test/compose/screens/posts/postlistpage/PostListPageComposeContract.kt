package com.test.compose.screens.posts.postlistpage

import androidx.lifecycle.ViewModel
import com.test.compose.common.ComposePageContract
import com.test.compose.common.PageState
import com.test.compose.screens.posts.Post
import kotlinx.coroutines.flow.MutableStateFlow

abstract class PostListPageComposeContract :
    ComposePageContract<PostListPageComposeContract.UiState,
            PostListPageComposeContract.Effect>, ViewModel() {

    override val _pageState: MutableStateFlow<PageState<UiState>> =
        MutableStateFlow(PageState.Loading())

    override var _uiState: UiState = UiState()

    data class UiState(
        val posts: List<Post> = emptyList()
    )

    sealed class Effect {
        object OnBackPressed : Effect()
        data class ShowToast(val message: String) : Effect()
    }
}
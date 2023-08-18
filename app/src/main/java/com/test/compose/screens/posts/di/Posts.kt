package com.test.compose.screens.posts.di

import com.test.compose.network.Ktor
import com.test.compose.screens.posts.postlistpage.PostListPageViewModel
import com.test.compose.screens.posts.PostsRepo
import com.test.compose.screens.posts.PostsRepoImpl
import com.test.compose.screens.posts.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Posts {
    val module = module {
        factory<PostsRepo> { PostsRepoImpl(Ktor.client) }
        viewModel { PostsViewModel(repo = get()) }
        viewModel { PostListPageViewModel(repo = get()) }
    }
}
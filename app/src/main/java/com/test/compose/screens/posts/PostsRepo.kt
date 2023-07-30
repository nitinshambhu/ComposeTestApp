package com.test.compose.screens.posts

import com.test.compose.common.resultOf
import com.test.compose.network.ApiRoutes
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.Url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface PostsRepo {
    suspend fun fetchPosts() : Result<List<Post>>
    fun clear()
}
class PostsRepoImpl (private val client: HttpClient) : PostsRepo {
    override suspend fun fetchPosts(): Result<List<Post>> {
        return withContext(Dispatchers.IO) {
            resultOf {
                client.get(url = Url(ApiRoutes.POSTS))
            }
        }
    }

    override fun clear() {
        client.close()
    }
}
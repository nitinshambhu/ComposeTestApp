package com.test.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.test.compose.screens.posts.PostsMain
import com.test.compose.screens.posts.PostsScreen
import com.test.compose.ui.theme.ComposeTestAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestAppTheme {
                PostsMain()
            }
        }
    }
}





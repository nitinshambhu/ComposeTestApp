package com.test.compose.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ScreenState {
    data class Loading(val message: String = "Loading, Please wait ...") : ScreenState()
    object Loaded : ScreenState()
    data class Error(val error: String) : ScreenState()
}

sealed class PageState<T> {
    data class Loading<T>(val message: String = "Loading, Please wait ...") : PageState<T>()
    data class Loaded<T>(val uiState: T) : PageState<T>()
    data class Error<T>(val error: String) : PageState<T>()
}

sealed class Test(val amount: String = "") : Parcelable {
    @Parcelize
    data class type(val amount1: String = "", val id: Int = 0) : Test(amount1)
}
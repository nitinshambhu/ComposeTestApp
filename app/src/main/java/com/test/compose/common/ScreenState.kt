package com.test.compose.common

 sealed class ScreenState<T> {
    data class Loading<T>(val message: String = "Loading, Please wait ..."): ScreenState<T>()
    data class Loaded<T>(val data: T): ScreenState<T>()
    data class Error<T>(val error: String): ScreenState<T>()
}


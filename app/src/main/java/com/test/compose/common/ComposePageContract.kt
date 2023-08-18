package com.test.compose.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update

interface ComposePageContract<STATE, EFFECT> {

    val _pageState: MutableStateFlow<PageState<STATE>>
    var _uiState: STATE

    @Composable
    fun collectUIState(): State<PageState<STATE>> = _pageState.asStateFlow().collectAsState()

    fun showLoadingPage(message: String) = _pageState.update { PageState.Loading(message) }
    fun showUIPage(block: STATE.() -> STATE) {
        _pageState.update {
            _uiState = block(_uiState)
            PageState.Loaded(_uiState)
        }
    }

    fun showErrorPage(errorMessage: String) = _pageState.update { PageState.Error(errorMessage) }

    private val _effect: MutableSharedFlow<EFFECT>
        get() = MutableSharedFlow()

    suspend fun postEffect(effect: EFFECT) {
        _effect.emit(effect)
    }

    suspend fun collectSideEffect(block: (EFFECT) -> Unit) {
        _effect.asSharedFlow().collectLatest {
            block(it)
        }
    }

}
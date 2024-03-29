package com.test.compose.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

interface ComposeContract<STATE, EFFECT> {

    val _uiState: MutableStateFlow<STATE>

    @Composable
    fun collectUIState(): State<STATE> = _uiState.asStateFlow().collectAsState()

    fun initialState(): STATE

    fun updateUiState(block: STATE.() -> STATE) {
        _uiState.update {
            block(it)
        }
    }

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
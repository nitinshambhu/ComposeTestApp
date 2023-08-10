package com.test.compose.common

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface ComposeContract<STATE, EFFECT> {
    private val _uiState: MutableStateFlow<STATE>
        get() = MutableStateFlow(initialState())
    val uiState: StateFlow<STATE>
        get() = _uiState.asStateFlow()

    private val _effect: MutableSharedFlow<EFFECT>
        get() = MutableSharedFlow()

    fun initialState(): STATE
    suspend fun postEffect(effect: EFFECT) {
        _effect.emit(effect)
    }

    fun updateUiState(block: STATE.() -> STATE) {
        _uiState.update {
            block(it)
        }
    }

}
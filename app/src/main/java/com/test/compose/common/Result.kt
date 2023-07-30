package com.test.compose.common

import kotlinx.coroutines.CancellationException

/**
 * Calls the specified function block and returns its encapsulated result
 * if invocation was successful, catching any Throwable exception that was thrown
 * from the block function execution and encapsulating it as a failure.
 */
inline fun <R> resultOf(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Throwable) {
        when(e) {
            is Error, is CancellationException -> throw e
            else -> Result.failure(e)
        }
    }
}

/**
 * Calls the specified function [block] with `this` value as its receiver and returns
 * its encapsulated result if invocation was successful,catching any [Throwable] exception
 * that was thrown from the [block] function execution and encapsulating it as a failure.
 */
inline fun <T, R> T.resultOf(block: T.() -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: Throwable) {
        when(e) {
            is Error, is CancellationException -> throw e
            else -> Result.failure(e)
        }
    }
}

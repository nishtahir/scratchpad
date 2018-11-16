package com.nishtahir

sealed class Result<out Success, out ErrorCause> {
    companion object {
        fun <T> success(value: T): Result.Ok<T> = Result.Ok(value)
        fun <E> error(errors: List<E>): Result.Error<E> = Result.Error(errors)
    }

    data class Ok<out T> constructor(val data: T) : Result<T, Nothing>()
    data class Error<out E> constructor(val causes: List<E>) : Result<Nothing, E>()
}
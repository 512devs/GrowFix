package com.dev512.growfix.cross.commons

import com.dev512.growfix.cross.exceptions.BaseException

sealed interface ResultState<T> {
    data class Success<T>(val data: T): ResultState<T>
    data class Error<T>(val exception: BaseException): ResultState<T>
}
package com.dev512.growfix.cross.commons

import com.dev512.growfix.cross.exceptions.BaseException

sealed interface UIState<T> {
    class Loading<T> : UIState<T>
    data class Success<T>(val data: T) : UIState<T>
    data class Error<T>(val exception: BaseException) : UIState<T>
}
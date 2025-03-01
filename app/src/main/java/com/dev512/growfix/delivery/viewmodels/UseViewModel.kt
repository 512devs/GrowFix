package com.dev512.growfix.delivery.viewmodels

import androidx.lifecycle.ViewModel
import com.dev512.growfix.cross.commons.ResultState
import com.dev512.growfix.cross.commons.UIState
import com.dev512.growfix.domain.entities.User
import com.dev512.growfix.domain.usecases.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow

class UseViewModel constructor(private val getUserUseCase: GetUserUseCase) : ViewModel() {

    private val mUserState: MutableStateFlow<UIState<User>> by lazy { MutableStateFlow(UIState.Loading()) }

    fun getUser() {
        when (val userState = getUserUseCase()) {
            is ResultState.Error -> {
                mUserState.value = UIState.Error(userState.exception)
            }

            is ResultState.Success -> {
                mUserState.value = UIState.Success(userState.data)
            }
        }

    }

    fun getUserByEmail(email: String) {
        when (val userState = getUserUseCase(email = email)) {
            is ResultState.Error -> {
                mUserState.value = UIState.Error(userState.exception)
            }

            is ResultState.Success -> {
                mUserState.value = UIState.Success(userState.data)
            }
        }
    }
}
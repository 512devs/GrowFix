package com.dev512.growfix.domain.repositories

import com.dev512.growfix.cross.commons.ResultState
import com.dev512.growfix.domain.entities.User

interface UserRepository {
    fun getUser(): ResultState<User>
    fun getUserByEmail(email: String): ResultState<User>
}
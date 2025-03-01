package com.dev512.growfix.domain.usecases

import com.dev512.growfix.cross.commons.ResultState
import com.dev512.growfix.domain.entities.User
import com.dev512.growfix.domain.repositories.UserRepository

class GetUserUseCase constructor(private val userRepository: UserRepository) {

    operator fun invoke(): ResultState<User> {
        return userRepository.getUser()
    }

    operator fun invoke(email: String): ResultState<User> {
        return userRepository.getUserByEmail(email)
    }
}
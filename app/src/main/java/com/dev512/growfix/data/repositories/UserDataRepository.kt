package com.dev512.growfix.data.repositories

import com.dev512.growfix.cross.commons.ResultState
import com.dev512.growfix.cross.exceptions.NotFoundException
import com.dev512.growfix.data.sources.local.database.UserDBLocalDataSource
import com.dev512.growfix.data.sources.remote.UserRemoteDataSource
import com.dev512.growfix.domain.entities.User
import com.dev512.growfix.domain.repositories.UserRepository

class UserDataRepository constructor(
    private val userDBLocalDataSource: UserDBLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) :
    UserRepository {

    override fun getUser(): ResultState<User> {
        val user = if (userDBLocalDataSource.getUser() == null) {
            userRemoteDataSource.getUser()
        } else userRemoteDataSource.getUser()

        return if (user == null) {
            ResultState.Error(NotFoundException())
        } else ResultState.Success(user)

    }

    override fun getUserByEmail(email: String): ResultState<User> {
        val user = if (userDBLocalDataSource.getUserByEmail(email) == null) {
            userRemoteDataSource.getUserByEmail(email)
        } else userRemoteDataSource.getUserByEmail(email)

        return if (user == null) {
            ResultState.Error(NotFoundException())
        } else ResultState.Success(user)
    }
}
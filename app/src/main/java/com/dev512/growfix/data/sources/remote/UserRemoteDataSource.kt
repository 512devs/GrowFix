package com.dev512.growfix.data.sources.remote

import com.dev512.growfix.domain.entities.User

class UserRemoteDataSource {
    fun getUser(): User? {
        return User("user01remote", "user01@gmail.com")
    }

    fun getUserByEmail(email: String): User? {
        return User("user01remote", email)
    }
}
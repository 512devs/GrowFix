package com.dev512.growfix.data.sources.local.database

import com.dev512.growfix.domain.entities.User

class UserDBLocalDataSource {

    fun getUser(): User? {
        return User("user01", "user01@gmail.com")
    }

    fun getUserByEmail(email: String): User? {
        return User("user01", email)
    }
}
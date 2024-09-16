package com.example.androidapplication.data

import com.example.androidapplication.domain.User
import com.example.androidapplication.domain.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserRepository {


    override suspend fun loginUser(userRequest: User): User {
        return userApiService.loginUser(userRequest)

    }
}

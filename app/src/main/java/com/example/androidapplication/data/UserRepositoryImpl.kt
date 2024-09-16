package com.example.androidapplication.data

import com.app.nit3213.data.DashboardResponse
import com.example.androidapplication.Constants
import com.example.androidapplication.domain.User
import com.example.androidapplication.domain.UserRepository
import com.example.androidapplication.domain.UserResponse
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApiService: UserApiService
) : UserRepository {


    override suspend fun loginUser(userRequest: User):UserResponse {
        return userApiService.loginUser("/sydney/auth",userRequest)

    }

    override suspend fun getDashboardData(keypass: String): DashboardResponse {
        return userApiService.getDashboardData(Constants.userKey)
    }
}

package com.example.androidapplication.domain

import com.app.nit3213.data.DashboardResponse
import com.example.androidapplication.Constants
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userRequest:User): UserResponse {
        return userRepository.loginUser(userRequest)
    }

    suspend operator fun invoke(): DashboardResponse {
        return userRepository.getDashboardData(Constants.userKey)
    }
}

package com.example.androidapplication.domain

import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(userRequest:User): User {
        return userRepository.loginUser(userRequest)
    }
}

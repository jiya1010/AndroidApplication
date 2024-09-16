// Domain Layer - UserRepository.kt
package com.example.androidapplication.domain


interface UserRepository {
    suspend fun loginUser(userRequest: User): User
}

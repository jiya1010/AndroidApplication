// Domain Layer - UserRepository.kt
package com.example.androidapplication.domain

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url


interface UserRepository {
    @POST("/sydney/auth")
    suspend fun loginUser(@Body userRequest: User): UserResponse
}

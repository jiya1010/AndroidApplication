package com.example.androidapplication.data

import com.example.androidapplication.domain.User
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApiService {
    @POST("users/{id}")
    suspend fun loginUser(userRequest:User): User
}

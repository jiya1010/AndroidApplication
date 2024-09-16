package com.example.androidapplication.data

import com.example.androidapplication.domain.User
import com.example.androidapplication.domain.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url

interface UserApiService {
    @POST
    suspend fun loginUser(@Url url: String,@Body userRequest:User): UserResponse
}

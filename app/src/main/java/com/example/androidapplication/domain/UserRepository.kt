// Domain Layer - UserRepository.kt
package com.example.androidapplication.domain

import com.app.nit3213.data.DashboardResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url


interface UserRepository {
    @POST("/sydney/auth")
    suspend fun loginUser(@Body userRequest: User): UserResponse
    @GET("/dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): DashboardResponse
}

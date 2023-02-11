package com.example.dogo_android.sign

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInterface {
    @POST("/app/users")
    fun join(@Body signRequest: JoinRequest): Call<SignResponse>

    @POST("/app/login")
    fun login(@Body signRequest: LoginRequest): Call<SignResponse>

}
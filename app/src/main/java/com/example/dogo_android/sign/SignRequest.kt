package com.example.dogo_android.sign

import com.google.gson.annotations.SerializedName

data class JoinRequest(
    @SerializedName(value = "email")val email: String,
    @SerializedName(value = "password")val password: String,
    @SerializedName(value = "nickname")val nickname: String?,
    @SerializedName(value = "address")val address: String?,
    @SerializedName(value = "age")val age: String?,
    @SerializedName(value = "gender")val gender: String?,
    @SerializedName(value = "breed")val breed: String?,
    @SerializedName(value = "dogAge")val dogAge: String?,
    @SerializedName(value = "introduce")val introduce: String?,
    @SerializedName(value = "profileImage")val profileImage: String?,
    @SerializedName(value = "status")val status: String?,
)
data class LoginRequest(
    @SerializedName(value = "email")val email: String,
    @SerializedName(value = "password")val password: String,
)

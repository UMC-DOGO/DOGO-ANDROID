package com.example.dogo_android.sign

import com.google.gson.annotations.SerializedName

data class SignResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: SignResult?
)
data class SignResult(
    @SerializedName("userId") val userId: Int,
    @SerializedName("jwt") val jwt: String,
)


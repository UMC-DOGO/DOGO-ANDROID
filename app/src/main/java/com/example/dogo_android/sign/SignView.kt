package com.example.dogo_android.sign

import kotlin.Result

interface LoginView {
    fun onLoginSuccess(code : Int, result : SignResult)
    fun onLoginFailure()
}

interface JoinView {
    fun onJoinSuccess()
    fun onJoinFailure()
}
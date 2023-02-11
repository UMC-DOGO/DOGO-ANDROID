package com.example.dogo_android.sign

import android.util.Log
import com.example.dogo_android.networkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignService {
    private lateinit var joinView: JoinView
    private lateinit var loginView: LoginView

    fun setJoinView(joinView: JoinView){
        this.joinView = joinView
    }
    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    fun join(joinRequest: JoinRequest) {

        val joinService = networkModule.getRetrofit().create(SignInterface::class.java)

        joinService.join(joinRequest).enqueue(object : Callback<SignResponse> {
            override fun onResponse(call: Call<SignResponse>, response: Response<SignResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    val joinResponse: SignResponse = response.body()!!

                    Log.d("JOIN-RESPONSE", joinResponse.toString())
                    when (joinResponse.code) {
                        1000 -> joinView.onJoinSuccess()
                        else -> {
                            joinView.onJoinFailure()
                            Log.d("JOIN-REQUEST", joinRequest.toString())
                        }

                    }
                }
            }
            override fun onFailure(call: Call<SignResponse>, t: Throwable) {
                Log.d("JOIN-ACT/ERROR", t.message.toString())
            }
        })
    }

    fun login(loginRequest: LoginRequest) {
        val loginService = networkModule.getRetrofit().create(SignInterface::class.java)

        loginService.login(loginRequest).enqueue(object : Callback<SignResponse> {
            override fun onResponse(call: Call<SignResponse>, response: Response<SignResponse>) {
                if (response.isSuccessful && response.code() == 200) {
                    val loginResponse: SignResponse = response.body()!!
                    Log.d("LOGIN-RESPONSE", loginResponse.toString())
                    //loginView.onLoginSuccess(loginResponse.code, loginResponse.result!!)
                    when (val code = loginResponse.code) {
                        1000 -> loginView.onLoginSuccess(code, loginResponse.result!!)
                        else -> loginView.onLoginFailure()
                    }
                }
            }

            override fun onFailure(call: Call<SignResponse>, t: Throwable) {
                Log.d("LOGIN-ACT/ERROR", t.message.toString())
            }
        })
    }
}
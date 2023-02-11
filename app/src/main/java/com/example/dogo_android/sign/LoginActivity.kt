package com.example.dogo_android.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dogo_android.GlobalApplication
import com.example.dogo_android.MainActivity
import com.example.dogo_android.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), LoginView {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //메인 페이지로 이동
        binding.loginBtn.setOnClickListener{
            login()
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
        }

        binding.loginBackIv.setOnClickListener {
            finish()
        }
    }

    private fun getUser(): LoginRequest {
        val email = binding.loginEmailEt.text.toString()
        val password = binding.loginPwEt.text.toString()

        return LoginRequest(email, password)
    }

    private fun login() {
        val signService = SignService()
        signService.setLoginView(this)
        signService.login(getUser())
    }

    private fun saveJwt(jwt: String, userId: Int) {
        GlobalApplication.spf.spfJwt = jwt
        GlobalApplication.spf.spfId = userId
        Log.d("login-jwt", "토큰 저장됨")
    }

    override fun onLoginSuccess(code : Int , result: SignResult) {
        when(code) {
            1000 -> {
                saveJwt(result.jwt, result.userId)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }
    override fun onLoginFailure() {

    }

}
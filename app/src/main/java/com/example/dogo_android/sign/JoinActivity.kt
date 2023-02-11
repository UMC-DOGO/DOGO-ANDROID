package com.example.dogo_android.sign

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.dogo_android.R
import com.example.dogo_android.databinding.ActivityJoinBinding
import java.util.regex.Pattern


class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //프로필 설정 페이지로 이동
        binding.joinNextBtn.setOnClickListener{
            checkPw()
//            val intent = Intent(this, SetupActivity::class.java)
//            startActivity(intent)
//            finish()
        }

        //사진 선택
        binding.joinImgBtn.setOnClickListener{
            DialogCamera(this).show()
        }

        //다음 버튼 활성화
        setNext()
    }

    private fun setNext() {
        if (binding.joinEmailEt.text.toString().isEmpty()) {
//            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            Log.d("입력여부", "미입력")
        }
        else if (binding.joinPwEt.text.toString().isEmpty()) {
            Log.d("입력여부", "미입력")
        }
        else if (binding.joinPwcheckEt.text.toString().isEmpty()) {
            Log.d("입력여부", "미입력")
        }
        else if (binding.joinNameEt.text.toString().isEmpty()) {
            Log.d("입력여부", "미입력")
        }
        else {
            binding.joinNextBtn.setBackgroundResource(R.drawable.img_next)
            binding.joinNextBtn.isEnabled = true
            Log.d("활성화여부", "활성화")
            return
        }
//        !(binding.joinEmailEt.text.toString().isEmpty() and binding.joinPwEt.text.toString().isEmpty() and binding.joinPwcheckEt.text.toString().isEmpty() and binding.joinNameEt.text.toString().isEmpty())
    }

    //비밀번호 체크
    private fun checkPw() {

        if(binding.joinPwEt.text.toString() != binding.joinPwcheckEt.text.toString()){
            binding.joinErrorIv3.visibility = View.VISIBLE
            binding.joinV3.setBackgroundColor(Color.parseColor("#F10000"))
            return
        }else{
            binding.joinErrorIv3.visibility = View.INVISIBLE
            binding.joinV3.setBackgroundColor(Color.parseColor("#404040"))
            nextJoin(binding.joinEmailEt.text.toString(), binding.joinPwcheckEt.text.toString(), binding.joinNameEt.text.toString())
        }
    }

    private fun nextJoin(email: String, password: String, nickName: String){
        val intent = Intent(this, SetupActivity::class.java)
        intent.putExtra("email", email)
        intent.putExtra("password", password)
        intent.putExtra("nickname", nickName)
        Log.d("JOIN", email+password+nickName)
        startActivity(intent)
        finish()
    }


}
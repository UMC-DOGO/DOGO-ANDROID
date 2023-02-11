package com.example.dogo_android.chatting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogo_android.databinding.ActivityUserprofileBinding
import com.google.android.material.tabs.TabLayoutMediator

class UserprofileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserprofileBinding
    private val tabprofile = arrayListOf("커뮤니티", "중고마켓")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserprofileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.userprofileBackIv.setOnClickListener {
            finish()
        }
        binding.userprofileMessageBtn.setOnClickListener{
            finish()
        }

        //뷰페이저 연결
        val AdapterUserprofile= UserprofileVPAdapter(this)
        binding.userprofileViewpager.adapter= AdapterUserprofile
        TabLayoutMediator(binding.userprofileTab, binding.userprofileViewpager){
                tab, position -> tab.text = tabprofile[position]
        }.attach()
    }

}
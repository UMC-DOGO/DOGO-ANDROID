package com.example.dogo_android.chatting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogo_android.databinding.FragmentChattingBinding


class ChattingFragment : Fragment() {
    private lateinit var binding: FragmentChattingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChattingBinding.inflate(inflater, container,false)

        binding.chatChatlistCl.setOnClickListener{
            val intent = Intent(context, ChattingRoomActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}
package com.example.dogo_android.chatting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dogo_android.databinding.FragmentUserprofileListBinding


class UserProfileListFragment : Fragment() {
    private lateinit var binding: FragmentUserprofileListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserprofileListBinding.inflate(inflater, container, false)

        return binding.root
    }
}
package com.example.dogo_android.chatting

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class UserprofileVPAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> UserProfileListFragment()
            else -> UserProfileListFragment()
        }
    }

}
package com.example.dogo_android.chatting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogo_android.R
import com.example.dogo_android.databinding.ActivityChatroomBinding
import kotlinx.android.synthetic.main.activity_chatroom.*

class ChattingRoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatroomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatroomBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var arrayList = arrayListOf("")
//        val chatRVAdapter = ChattingRVAdapter(this, arrayList)
//        //어댑터 선언
//        binding.chatroomRv.adapter = chattingRVAdapter
//        binding.chatroomRv.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.chatroomRv.setHasFixedSize(true)//아이템이 추가삭제될때 크기측면에서 오류 안나게 해줌
//
//        chatroom_send_iv.setOnClickListener {
//            //아이템 추가 부분
//            sendMessage()
//
//        }

        binding.chatroomBackIv.setOnClickListener {
            finish()
        }
        binding.chatroomProfileIv.setOnClickListener {
            val intent = Intent(this, UserprofileActivity::class.java)
            startActivity(intent)
        }
        binding.chatroomSendIv.setOnClickListener {
            val inputMethodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(binding.chatroomSendIv.windowToken, 0)
            binding.chatroomM2Tv.text = binding.chatroomEt.text.toString()
            binding.chatroomM2Tv.visibility = View.VISIBLE
            binding.chatroomTime2Tv.visibility = View.VISIBLE
            binding.chatroomEt.setText("")
        }
    }

//    private fun sendMessage() {
//        val now = System.currentTimeMillis()
////        val date = Date(now)
//        val sdf = SimpleDateFormat("yyyy-MM-dd")
//
//        val getTime = sdf.format(date)

//        val item = ChattingModel(preferences.getString("name",""),chating_Text.text.toString(),"example", getTime)
//        chattingr.addItem(item)
//        chattin.notifyDataSetChanged()
//

//        chatroom_et.setText("")
//    }
}
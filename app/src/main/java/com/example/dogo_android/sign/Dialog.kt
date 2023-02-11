package com.example.dogo_android.sign

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import com.example.dogo_android.databinding.DialogCameraBinding

class DialogCamera (
    context: Context,
) : Dialog(context) {

    private lateinit var binding: DialogCameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() = with(binding) {
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.diacameraCancelBtn.setOnClickListener {
            dismiss()
        }
        binding.diacameraCameraBtn.setOnClickListener {
            dismiss()
        }
        binding.diacameraGalleryBtn.setOnClickListener {
            dismiss()
        }
    }
}
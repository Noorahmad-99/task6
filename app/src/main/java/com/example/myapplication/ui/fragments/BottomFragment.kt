package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.BottomFragmentBinding
import com.example.myapplication.util.Constant


class BottomFragment : BaseFragment<BottomFragmentBinding>() {

    override val LOG_TAG: String = "Bottom_Fragment"
    override val bindingInflater: (LayoutInflater) ->
    BottomFragmentBinding = BottomFragmentBinding::inflate

    override fun addCallbacks() {}

    override fun setUp() {
        arguments?.let {
            val data: String = it.getString(Constant.DATA_KEY)!!
            binding?.apply {
                bottom.text = data

            }
        }
    }


    override fun data(text: String) {}

}


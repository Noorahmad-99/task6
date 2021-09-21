package com.example.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.myapplication.ui.interfaces.BaseInterface

abstract class BaseActivity  <VB : ViewBinding> : AppCompatActivity()
    , BaseInterface<VB> {

    override var _binding: ViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)

        setUp()

    }


}
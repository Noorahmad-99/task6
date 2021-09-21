package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.myapplication.ui.interfaces.BaseInterface

abstract class BaseFragment<VB: ViewBinding> : Fragment() , BaseInterface<VB> {

        override var _binding: ViewBinding? = null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            setUp()
            addCallbacks()
        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle? ): View? {
            _binding = bindingInflater(layoutInflater)
            return _binding?.root
        }

        abstract fun addCallbacks()


    }

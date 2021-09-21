package com.example.myapplication.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.ui.fragments.TopFragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.fragments.BottomFragment
import com.example.myapplication.util.Constant
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlin.contracts.contract

class MainActivity :  BaseActivity<ActivityMainBinding>() {

    private lateinit var bottomFragment : BottomFragment
    override val LOG_TAG: String = "Main_Activity"

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
            = ActivityMainBinding::inflate

    private val compositeDisposable = CompositeDisposable()


    override fun setUp() {}


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    override fun data(text: String) {
        bottomFragment = BottomFragment()
        val bundle = Bundle()
        bundle.putString(Constant.DATA_KEY,text)
        bottomFragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.bottom_fragment, bottomFragment).commit()
    }


}
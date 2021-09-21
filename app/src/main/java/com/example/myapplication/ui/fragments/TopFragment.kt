package com.example.myapplication.ui.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.core.widget.doOnTextChanged
import com.example.myapplication.util.Constant
import com.example.myapplication.databinding.TopFragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class TopFragment : BaseFragment<TopFragmentBinding>() {

    override val LOG_TAG: String = "Top_Fragment"
    override val bindingInflater: (LayoutInflater) ->
    TopFragmentBinding = TopFragmentBinding::inflate

    override fun addCallbacks() {}

    override fun setUp() {
        initObserve()
    }

    private fun initObserve() {
        val subject = PublishSubject.create<String> { emitter ->
            binding?.top?.doOnTextChanged { text, start, before, count ->
                emitter.onNext(text.toString())

            }
        }.debounce(1500, TimeUnit.MILLISECONDS)
         .observeOn(AndroidSchedulers.mainThread())


        subject.subscribe(
            { next ->
                   data(next)
            },
            { error ->
                Log.i(ContentValues.TAG, "error: ${error?.message}")
            }
        )

    }

    override fun data(text: String) {
    }


}

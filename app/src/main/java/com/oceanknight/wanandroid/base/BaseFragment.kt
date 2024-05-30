package com.oceanknight.wanandroid.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 *
 * author: Oceanknight
 * date: 2024/05/29
 * describe:
 */
abstract class BaseFragment<B : ViewDataBinding>(@LayoutRes contentLayoutId: Int = 0) :
    Fragment(contentLayoutId) {

    val binding: B
        get() {
            return DataBindingUtil.bind(requireView())!!
        }

    protected abstract fun initView()
    protected abstract fun initData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DataBindingUtil.bind<B>(view)

        try {
            initView()
            initData()
        } catch (e: Exception) {
            Log.e("Engine", "Initializing failure", e)
        }
    }
}

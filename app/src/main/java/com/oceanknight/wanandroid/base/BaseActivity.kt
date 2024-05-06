package com.oceanknight.wanandroid.base

import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

public abstract class BaseActivity<B : ViewDataBinding>(@LayoutRes val contentLayoutRes: Int = 0) :
    AppCompatActivity(contentLayoutRes) {

    lateinit var binding: B
    lateinit var rootView: View

    override fun setContentView(layoutResID: Int) {
        rootView = layoutInflater.inflate(contentLayoutRes, null)
        setContentView(rootView)
        binding = DataBindingUtil.bind(rootView)!!
        init()
    }

    open fun init() {
        try {
            initView()
            initData()
        } catch (e: Exception) {
            Log.e("Engine", "Initializing failure", e)
        }
    }

    protected abstract fun initView()
    protected abstract fun initData()

    fun requireActivity(): AppCompatActivity {
        return this
    }
}
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

    private var _binding: B? = null
    val binding: B
        get() = _binding!!

    protected abstract fun initView()
    protected abstract fun initData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Zyp", "Base bind")
        _binding = DataBindingUtil.bind<B>(view)

        try {
            initView()
            initData()
        } catch (e: Exception) {
            Log.e("Engine", "Initializing failure", e)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // TODO: 解决ViewPager2内部问题后启用下面这行代码，否则会导致配合navigation使用时造成内存泄露
//        _binding = null
    }
}

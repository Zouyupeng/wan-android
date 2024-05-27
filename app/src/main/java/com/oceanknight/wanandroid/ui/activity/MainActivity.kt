package com.oceanknight.wanandroid.ui.activity

import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseActivity
import com.oceanknight.wanandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun initView() {
        initNavigationBar()
    }

    override fun initData() {

    }

    /**
     * 初始化底部导航栏
     */
    private fun initNavigationBar() {
        val iconList = arrayListOf(R.drawable.selector_navigation_home, R.drawable.selector_navigation_search,
            R.drawable.selector_navigation_collections, R.drawable.selector_navigation_mine)

        iconList.forEach {
            binding.bottomNavigationBar.addTab(binding.bottomNavigationBar.newTab().setIcon(it))
        }

    }

}
package com.oceanknight.wanandroid.ui.activity

import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayout
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseActivity
import com.oceanknight.wanandroid.databinding.ActivityMainBinding
import com.oceanknight.wanandroid.utils.ext.addTab
import com.oceanknight.wanandroid.utils.interfaceinstance.OnTabSelectedListenerInstance

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
        val idList = arrayListOf(R.id.homeFragment, R.id.searchFragment, R.id.collectionsFragment, R.id.mineFragment)

        for (i in 0 until  4) {
            binding.bottomNavigationBar.addTab {
                setIcon(iconList[i])
                id = idList[i]
            }
        }

        binding.bottomNavigationBar.addOnTabSelectedListener(object : OnTabSelectedListenerInstance() {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                findNavController(R.id.nav_host_fragment).navigate(tab!!.id)
            } })
    }

}
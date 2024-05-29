package com.oceanknight.wanandroid.utils.interfaceinstance

import com.google.android.material.tabs.TabLayout

/**
 *
 * author: Oceanknight
 * date: 2024/05/29
 * describe:
 * tabLayout 监听器
 */
abstract class OnTabSelectedListenerInstance : TabLayout.OnTabSelectedListener{
    override fun onTabSelected(tab: TabLayout.Tab?) {}

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}
}
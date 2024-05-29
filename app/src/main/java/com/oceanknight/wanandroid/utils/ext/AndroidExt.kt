package com.oceanknight.wanandroid.utils.ext

import androidx.annotation.LayoutRes
import com.google.android.material.tabs.TabLayout

/**
 *
 * author: Oceanknight
 * date: 2024/05/29
 * describe:
 * 系统组件扩展
 */

fun TabLayout.addTab(block: TabLayout.Tab.() -> Unit = {}) {
    val newTab = this.newTab()
    newTab.block()
    this.addTab(newTab)

}


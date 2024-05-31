package com.oceanknight.wanandroid.utils.ext

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 *
 * author: Oceanknight
 * date: 2024/05/31
 * describe:
 */

fun Fragment.FragmentAdapter(
    fragments: List<Fragment>
): FragmentStateAdapter = object : FragmentStateAdapter(this) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
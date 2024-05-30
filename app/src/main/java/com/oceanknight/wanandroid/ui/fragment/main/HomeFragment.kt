package com.oceanknight.wanandroid.ui.fragment.main

import android.widget.Toast
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseFragment
import com.oceanknight.wanandroid.constants.Api
import com.oceanknight.wanandroid.databinding.FragmentHomeBinding
import com.oceanknight.wanandroid.net.model.HomeBanner
import com.oceanknight.wanandroid.ui.adapter.HomeBannerAdapter
import com.youth.banner.indicator.RoundLinesIndicator

/**
 *
 * author: Oceanknight
 * date: 2024/05/29
 * describe:
 */
class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun initView() {
        binding.homeBanner.setAdapter(HomeBannerAdapter())
            .setIndicator(RoundLinesIndicator(requireContext()))
            .setOnBannerListener { data, position ->
                Toast.makeText(requireContext(), "点击banner $position", Toast.LENGTH_SHORT).show()
            }
            .setIntercept(false)
    }

    override fun initData() {
        scopeNetLife {
            val bannerAsync = Get<List<HomeBanner>>(Api.BANNER)

            val bannerList = bannerAsync.await()

            binding.homeBanner.setDatas(bannerList)
        }
    }
}
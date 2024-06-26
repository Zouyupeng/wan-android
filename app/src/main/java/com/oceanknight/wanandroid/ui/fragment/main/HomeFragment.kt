package com.oceanknight.wanandroid.ui.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.google.android.material.tabs.TabLayoutMediator
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseFragment
import com.oceanknight.wanandroid.constants.Api
import com.oceanknight.wanandroid.databinding.FragmentHomeBinding
import com.oceanknight.wanandroid.net.model.HomeBanner
import com.oceanknight.wanandroid.ui.adapter.HomeBannerAdapter
import com.oceanknight.wanandroid.ui.fragment.home.HarmonyFragment
import com.oceanknight.wanandroid.ui.fragment.home.ProjectFragment
import com.oceanknight.wanandroid.ui.fragment.home.SquareFragment
import com.oceanknight.wanandroid.ui.fragment.home.TopFragment
import com.oceanknight.wanandroid.ui.fragment.home.WxArticleFragment
import com.oceanknight.wanandroid.ui.viewmodel.HomeViewModel
import com.oceanknight.wanandroid.utils.ext.FragmentAdapter
import com.youth.banner.indicator.RoundLinesIndicator

/**
 *
 * author: Oceanknight
 * date: 2024/05/29
 * describe:
 */
class HomeFragment: BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private var cachedView: View? = null

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Zyp", "onCreateView")
        if (homeViewModel.cachedHomeFragmentView == null) {
            Log.d("Zyp", "cachedView null")
            homeViewModel.firstInitFlag = true
            homeViewModel.cachedHomeFragmentView = inflater.inflate(R.layout.fragment_home, container, false)
        } else {
            homeViewModel.firstInitFlag = false
        }
        return homeViewModel.cachedHomeFragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Zyp", "onViewCreated")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun initView() {
        if (!homeViewModel.firstInitFlag) return
        Log.d("Zyp", "initView")


        // banner
        binding.homeBanner.setAdapter(HomeBannerAdapter())
            .setIndicator(RoundLinesIndicator(requireContext()))
            .setOnBannerListener { data, position ->
                Toast.makeText(requireContext(), "点击banner $position", Toast.LENGTH_SHORT).show()
            }
            .setIntercept(false)

        // tabLayout + viewPager2
        binding.vp.adapter = FragmentAdapter(listOf(TopFragment(), SquareFragment(), ProjectFragment(),
            WxArticleFragment(), HarmonyFragment()))
        TabLayoutMediator(binding.tabTop, binding.vp) { tab, position ->
            when(position) {
                0 -> tab.text = getString(R.string.top)
                1 -> tab.text = getString(R.string.square)
                2 -> tab.text = getString(R.string.project)
                3 -> tab.text = getString(R.string.wx_article)
                4 -> tab.text = getString(R.string.harmony)
            }
            // 去除长按气泡
            tab.view.tooltipText = ""
        }.attach()
    }

    override fun initData() {
        if (!homeViewModel.firstInitFlag) return
        scopeNetLife {
            val bannerAsync = Get<List<HomeBanner>>(Api.BANNER)

            val bannerList = bannerAsync.await()

            binding.homeBanner.setDatas(bannerList)
        }
    }
}
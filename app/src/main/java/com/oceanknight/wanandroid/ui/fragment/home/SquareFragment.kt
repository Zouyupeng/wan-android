package com.oceanknight.wanandroid.ui.fragment.home

import com.drake.brv.utils.setup
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseFragment
import com.oceanknight.wanandroid.constants.Api
import com.oceanknight.wanandroid.databinding.FragmentSquareBinding
import com.oceanknight.wanandroid.net.model.Articles

/**
 *
 * author: Oceanknight
 * date: 2024/05/31
 * describe:
 * 广场
 */
class SquareFragment: BaseFragment<FragmentSquareBinding>(R.layout.fragment_square) {
    override fun initView() {
        binding.squareArticleRv.setup {
            addType<Articles.Article>(R.layout.item_article)
        }
        binding.squareArticlePage.onRefresh {
            fetchSquareData()
        }
    }

    override fun initData() {
        fetchSquareData()
    }

    private fun fetchSquareData() {
        scopeNetLife {
            val squareArticleRes = Get<Articles>(Api.USER_ARTICLE + (binding.squareArticlePage.index - 1)).await()
            binding.squareArticlePage.addData(squareArticleRes.articleList)
        }
    }
}
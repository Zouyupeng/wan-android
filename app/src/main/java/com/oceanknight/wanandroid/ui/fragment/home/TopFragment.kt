package com.oceanknight.wanandroid.ui.fragment.home

import com.drake.brv.utils.setup
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseFragment
import com.oceanknight.wanandroid.constants.Api
import com.oceanknight.wanandroid.databinding.FragmentTopBinding
import com.oceanknight.wanandroid.net.model.Articles

/**
 *
 * author: Oceanknight
 * date: 2024/05/31
 * describe:
 */
class TopFragment: BaseFragment<FragmentTopBinding>(R.layout.fragment_top) {
    override fun initView() {
        binding.topArticleRv.setup {
            addType<Articles.Article>(R.layout.item_article)
        }
        binding.topArticlePage.onRefresh {
            getTopData()
        }
    }

    override fun initData() {
        getTopData()
    }

    private fun getTopData() {
        scopeNetLife {
            val homeArticleAsync = Get<Articles>(Api.HOME_ARTICLE + (binding.topArticlePage.index - 1))
            val topArticleAsync = if (binding.topArticlePage.index == 1) Get<List<Articles.Article>>(Api.TOP_ARTICLE)
                                    else null

            val articles = homeArticleAsync.await()
            val topArticles = topArticleAsync?.await() ?: listOf<Articles.Article>()

            binding.topArticlePage.addData(topArticles + articles.articleList)
        }
    }
}
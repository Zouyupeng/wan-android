package com.oceanknight.wanandroid.ui.fragment.home

import com.drake.brv.utils.setup
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseFragment
import com.oceanknight.wanandroid.databinding.FragmentTopBinding
import com.oceanknight.wanandroid.net.model.Article

/**
 *
 * author: Oceanknight
 * date: 2024/05/31
 * describe:
 */
class TopFragment: BaseFragment<FragmentTopBinding>(R.layout.fragment_top) {
    override fun initView() {
        binding.topArticleRv.setup {
            addType<Article.Data>(R.layout.item_article)
        }
        binding.topArticlePage.onRefresh {

        }
    }

    override fun initData() {

    }
}
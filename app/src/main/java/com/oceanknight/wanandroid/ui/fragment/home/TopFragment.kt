package com.oceanknight.wanandroid.ui.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Zyp", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Zyp", "onViewCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Zyp", "onDestroyView")
    }


    override fun initView() {

        Log.i("Zyp", "top initView")
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
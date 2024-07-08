package com.oceanknight.wanandroid.ui.fragment.home

import com.drake.brv.utils.setup
import com.drake.net.Get
import com.drake.net.utils.scopeNetLife
import com.oceanknight.wanandroid.R
import com.oceanknight.wanandroid.base.BaseFragment
import com.oceanknight.wanandroid.constants.Api
import com.oceanknight.wanandroid.databinding.FragmentProjectBinding
import com.oceanknight.wanandroid.net.model.ProjectModel

/**
 *
 * author: Oceanknight
 * date: 2024/05/31
 * describe:
 * 项目
 */
class ProjectFragment: BaseFragment<FragmentProjectBinding>(R.layout.fragment_project) {
    override fun initView() {
        binding.projectArticleRv.setup {
            addType<ProjectModel.Project>(R.layout.item_project)
        }
        binding.projectArticlePage.onRefresh { fetchProjectData() }
    }

    override fun initData() {
        fetchProjectData()
    }

    private fun fetchProjectData() {
        scopeNetLife {
            val projectArticleRes = Get<ProjectModel>(Api.PROJECT_LIST + (binding.projectArticlePage.index - 1)).await()
            binding.projectArticlePage.addData(projectArticleRes.projectList)
        }
    }
}
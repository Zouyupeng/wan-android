package com.oceanknight.wanandroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oceanknight.wanandroid.databinding.ComponentBannerItemBinding
import com.oceanknight.wanandroid.net.model.HomeBanner
import com.youth.banner.adapter.BannerAdapter

/**
 * @author  Oceanknight
 * @date    2024/5/30 22:46
 * --------------------------------------
 * @description
 *  首页banner用适配器
 */
class HomeBannerAdapter(data: MutableList<HomeBanner>? = null) : BannerAdapter<HomeBanner, HomeBannerAdapter.BannerViewHolder>(data){

    class BannerViewHolder(val binding: ComponentBannerItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding = ComponentBannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun onBindView(
        holder: BannerViewHolder,
        data: HomeBanner,
        position: Int,
        size: Int
    ) {
        holder.binding.m = data
    }
}
package com.yasser.thmanyahtask.modules.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.yasser.thmanyahtask.databinding.ItemEpisodeBinding
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.EpisodeDiffUtils
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.EpisodeUiModel


class EpisodeListAdapter constructor(
) : RecyclerView.Adapter<EpisodeListAdapter.ViewHolder>() {
    private val mDiffer: AsyncListDiffer<EpisodeUiModel?> =
        AsyncListDiffer(this, EpisodeDiffUtils)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mDiffer.currentList[position]!!
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bind = ItemEpisodeBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(bind)
    }

    inner class ViewHolder constructor(private val binding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: EpisodeUiModel) {


        }
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    fun submitList(items: List<EpisodeUiModel>) {
        mDiffer.submitList(items)
    }
}



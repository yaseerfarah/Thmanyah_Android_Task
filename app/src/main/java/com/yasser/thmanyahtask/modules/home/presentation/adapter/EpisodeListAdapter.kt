package com.yasser.thmanyahtask.modules.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.core.extensions.loadImage
import com.yasser.thmanyahtask.core.extensions.onClick
import com.yasser.thmanyahtask.databinding.ItemEpisodeBinding
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.EpisodeDiffUtils
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.EpisodeUiModel
import java.util.concurrent.TimeUnit


class EpisodeListAdapter constructor(
    private val context: Context,
    private val onPlayClick:(EpisodeUiModel)->Unit,
    private val onMenuClick:(EpisodeUiModel)->Unit
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
            binding.episodeImage.loadImage(item.image,placeholderDrawable = null, progressBar = binding.imageProgress)
            binding.episodeTitle.text=item.name
            binding.episodeCategory.text=item.podcastName
            val episodeDuration= context.resources.getQuantityString(if (item.timeUnit== TimeUnit.HOURS) R.plurals.hours else R.plurals.minutes ,item.duration.toInt(),item.duration.toInt())
            binding.episodeDate.text=episodeDuration
            initAction(item)

        }
        private fun initAction(item: EpisodeUiModel){
            binding.playBtn.onClick {
                onPlayClick.invoke(item)
            }
            binding.menuBtn.onClick {
                onMenuClick.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    fun submitList(items: List<EpisodeUiModel>) {
        mDiffer.submitList(items)
    }
}



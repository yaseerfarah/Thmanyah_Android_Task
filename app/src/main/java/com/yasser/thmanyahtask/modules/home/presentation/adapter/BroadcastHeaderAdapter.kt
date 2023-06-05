package com.yasser.thmanyahtask.modules.home.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yasser.thmanyahtask.R
import com.yasser.thmanyahtask.core.extensions.loadImage
import com.yasser.thmanyahtask.core.extensions.onClick
import com.yasser.thmanyahtask.databinding.LayoutBroadcastHeaderBinding
import com.yasser.thmanyahtask.modules.home.presentation.adapter.listener.BroadcastActionListener
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.BroadcastUiModel
import java.util.concurrent.TimeUnit


class BroadcastHeaderAdapter constructor(
    private val context: Context,
    private val broadcastActionListener: BroadcastActionListener,
) : RecyclerView.Adapter<BroadcastHeaderAdapter.ViewHolder>() {

    private var broadcastUiModel:BroadcastUiModel?=null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(broadcastUiModel!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bind = LayoutBroadcastHeaderBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(bind)
    }

    inner class ViewHolder constructor(private val binding: LayoutBroadcastHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BroadcastUiModel) {
            binding.broadcastTitle.text=item.name
            binding.broadcastDescription.text=item.description
            binding.coverImage.loadImage(item.image,placeholderDrawable = null, progressBar = null)
            binding.likeImg.setImageResource(item.favoriteIcon)
            val episodeCount=context.resources.getQuantityString(R.plurals.episode,item.episodeCount.toInt(),item.episodeCount.toInt())
            val episodeDuration= context.resources.getQuantityString(if (item.timeUnit==TimeUnit.HOURS)R.plurals.hours else R.plurals.minutes ,item.episodeTotalDuration.toInt(),item.episodeTotalDuration.toInt())
            binding.broadcastEpisodesCount.text= "$episodeCount , $episodeDuration"
            initAction(item)
        }

        private fun initAction(item: BroadcastUiModel){
            binding.backBtn.onClick {
                broadcastActionListener.onBackClick()
            }
            binding.likeBtn.onClick {
                broadcastActionListener.onFavoriteClick(item)
            }
            binding.optionBtn.onClick {
                broadcastActionListener.onOptionClick()
            }
            binding.randomPlayBtn.onClick {
                broadcastActionListener.onPlayRandomEpisodesClick()
            }
            binding.downloadBtn.onClick {
                broadcastActionListener.onDownloadClick()
            }
            binding.playBtn.onClick {
                broadcastActionListener.onPlayEpisodesClick()
            }
        }

    }

    override fun getItemCount(): Int {
        return if(broadcastUiModel!=null) 1 else 0
    }

    fun setBroadcastUiModel(item:BroadcastUiModel) {
        broadcastUiModel = item
        notifyDataSetChanged()
    }
}



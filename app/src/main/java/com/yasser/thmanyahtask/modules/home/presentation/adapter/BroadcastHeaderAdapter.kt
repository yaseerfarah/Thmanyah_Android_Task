package com.yasser.thmanyahtask.modules.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yasser.thmanyahtask.databinding.LayoutBroadcastHeaderBinding
import com.yasser.thmanyahtask.modules.home.presentation.uimodel.BroadcastUiModel


class BroadcastHeaderAdapter constructor(
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



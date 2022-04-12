package com.zerodev.bmandroidtest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zerodev.bmandroidtest.DetailActivity
import com.zerodev.bmandroidtest.databinding.ItemDataSavedBinding
import com.zerodev.bmandroidtest.model.AppModel

class AppSavedAdapter : RecyclerView.Adapter<AppSavedAdapter.ViewHolder>() {

    private val listData = ArrayList<AppModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<AppModel>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDataSavedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.count()

    inner class ViewHolder(private val binding: ItemDataSavedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(appModel: AppModel) {
            binding.label.text = appModel.label
            binding.nbVisits.text = appModel.nbVisit.toString()

            binding.detail.setOnClickListener {
                val detail = Intent(itemView.context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_DETAIL, appModel)
                }
                it.context.startActivity(detail)
            }
        }
    }
}
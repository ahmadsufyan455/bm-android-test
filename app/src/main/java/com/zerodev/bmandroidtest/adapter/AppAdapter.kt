package com.zerodev.bmandroidtest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zerodev.bmandroidtest.DetailActivity
import com.zerodev.bmandroidtest.R
import com.zerodev.bmandroidtest.databinding.ItemDataBinding
import com.zerodev.bmandroidtest.model.AppModel

class AppAdapter(private val clickListener: OnClickListener) : RecyclerView.Adapter<AppAdapter.ViewHolder>() {

    private val listData = ArrayList<AppModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<AppModel>) {
        listData.clear()
        listData.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDataBinding.inflate(
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

    inner class ViewHolder(private val binding: ItemDataBinding) :
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

            binding.save.setOnClickListener {
                clickListener.onClick(appModel)
                binding.save.text = itemView.context.getString(R.string.saved)
            }
        }
    }
}

class OnClickListener(val clickListener: (appModel: AppModel) -> Unit) {
    fun onClick(appModel: AppModel) = clickListener(appModel)
}
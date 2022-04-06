package com.anzeh.databindingadapter.ui.activityes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anzeh.databindingadapter.data.model.User
import com.anzeh.databindingadapter.databinding.ItemRowBinding
import com.anzeh.databindingadapter.ui.base.adapter.BaseBindingRecyclerViewAdapter
import com.anzeh.databindingadapter.ui.base.adapter.BaseViewHolder

class UsersRecyclerAdapter(
    context: Context,
) : BaseBindingRecyclerViewAdapter<User>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemRowBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bindItem(items[position], position)
        }
    }

    inner class ViewHolder(private val binding: ItemRowBinding) :
        BaseViewHolder<User>(binding.root) {

        override fun bindItem(item: User?, position: Int) {
            binding.data = item

            binding.root.setOnClickListener {
                item?.let { it1 -> itemClickListener?.onItemClick(null, position, it1) }
            }
        }
    }

}
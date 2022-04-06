package com.anzeh.databindingadapter.binding

import androidx.recyclerview.widget.RecyclerView
import com.anzeh.databindingadapter.ui.base.adapter.BaseBindingRecyclerViewAdapter

fun RecyclerView?.setOnItemClickListener(
    onItemClickListener: BaseBindingRecyclerViewAdapter.OnItemClickListener?
) {
    this?.adapter?.let {
        if (this.adapter is BaseBindingRecyclerViewAdapter<*>) {
            (adapter as BaseBindingRecyclerViewAdapter<*>).itemClickListener = onItemClickListener
        }
    }

}

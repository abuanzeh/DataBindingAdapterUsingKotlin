package com.anzeh.databindingadapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("loadImage")
fun ImageView.loadImage(img: Int?) {
    img?.let { setImageResource(it) }
}

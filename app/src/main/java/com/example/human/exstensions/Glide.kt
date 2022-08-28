package com.example.human.exstensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.human.R

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_image)
        .into(this)
}
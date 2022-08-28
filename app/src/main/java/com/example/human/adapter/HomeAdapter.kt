package com.example.human.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.human.databinding.CustomItemBinding
import com.example.human.exstensions.loadImage
import com.example.human.model.ClothesDataClass

class HomeAdapter :
    ListAdapter<ClothesDataClass.Content, HomeAdapter.MainViewHolder>(
        ItemCallBack
    ) {

    var itemClick: ((ClothesDataClass.Content) -> Unit)? = null

    var checkClick: ((ClothesDataClass.Content) -> Unit)? = null

    inner class MainViewHolder(private val binding: CustomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val items = getItem(adapterPosition)
            binding.apply {
                tvPrice.text = items.price
                imageView.loadImage(items.image)

                itemView.setOnClickListener {
                    itemClick!!.invoke(items)
                }

                ivHeart.setOnClickListener {
                    checkClick!!.invoke(items)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CustomItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

}

object ItemCallBack : DiffUtil.ItemCallback<ClothesDataClass.Content>() {
    override fun areItemsTheSame(
        oldItem: ClothesDataClass.Content,
        newItem: ClothesDataClass.Content
    ): Boolean {
        return oldItem.price == newItem.price
    }

    override fun areContentsTheSame(
        oldItem: ClothesDataClass.Content,
        newItem: ClothesDataClass.Content
    ): Boolean {
        return oldItem == newItem
    }

}
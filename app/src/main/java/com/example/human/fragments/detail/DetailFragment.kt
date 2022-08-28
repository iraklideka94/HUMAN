package com.example.human.fragments.detail

import androidx.navigation.fragment.navArgs
import com.example.human.base.BaseFragment
import com.example.human.databinding.FragmentDetailBinding
import com.example.human.exstensions.loadImage

class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val args: DetailFragmentArgs by navArgs()

    override fun viewCreated() {
        binding.apply {
            tvPrice.text = args.price
            imageView.loadImage(args.image)
        }
    }

}
package com.example.human.fragments.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.human.adapter.HomeAdapter
import com.example.human.base.BaseFragment
import com.example.human.databinding.FragmentHomeBinding
import com.example.human.resource.Resource
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val itemAdapter = HomeAdapter()

    private val viewModel: HomeViewModel by viewModels()

    override fun viewCreated() {

        init()

        observers()

        itemClick()

        listeners()

    }

    private fun init() {
        binding.recycleView.apply {
            adapter = itemAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun observers() {
        lifecycleScope.launch {
            viewModel.getItems().collect {
                when (it) {
                    is Resource.Success -> {
                        itemAdapter.submitList(it.list)
                    }
                    is Resource.Error -> {
                        Toast.makeText(context, it.errorMsg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun listeners() {
        binding.apply {
            ivHeart.setOnClickListener {
                // findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHeartFragment())
            }

            btnCalculate.setOnClickListener {

            }
        }
    }

    private fun itemClick() {
        itemAdapter.itemClick = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    price = it.price,
                    image = it.image.toString()
                )
            )

            itemAdapter.checkClick = {
                binding.tvCounter.text = it.price
            }
        }
    }
}
package com.example.human.fragments.welcome

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.human.R
import com.example.human.base.BaseFragment
import com.example.human.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {

    private fun listeners() {
        binding.apply {
            ivFacebook.setOnClickListener {
                Toast.makeText(context, R.string.facebook, Toast.LENGTH_SHORT).show()
            }

            ivApple.setOnClickListener {
                Toast.makeText(context, R.string.apple, Toast.LENGTH_SHORT).show()
            }

            ivGoogle.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToLogInFragment())
            }

            tvSignUp.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment())
            }
        }
    }

    override fun viewCreated() {
        listeners()
    }
}
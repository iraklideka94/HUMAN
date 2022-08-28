package com.example.human.fragments.login

import android.util.Log.d
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.human.base.BaseFragment
import com.example.human.databinding.FragmentLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogInFragment : BaseFragment<FragmentLogInBinding>(FragmentLogInBinding::inflate) {

    private lateinit var mAuth: FirebaseAuth

    override fun viewCreated() {
        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            navigateHome()
        } else {
            listeners()
        }
    }

    private fun listeners() {
        binding.apply {
            btnSignIn.setOnClickListener {
                authLogIn()
            }

            tvSignUp.setOnClickListener {
                navigateRegister()
            }
        }
    }

    private fun authLogIn() {

        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "field is empty!!!", Toast.LENGTH_SHORT).show()
        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    d("gaga", "login")
                    navigateHome()
                } else {
                    Toast.makeText(context, "user not found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun navigateHome() {
        findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToHomeFragment())
    }

    private fun navigateRegister() {
        findNavController().navigate(LogInFragmentDirections.actionLogInFragmentToRegisterFragment())
    }

}
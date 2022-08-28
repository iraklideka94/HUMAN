package com.example.human.fragments.register

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.human.base.BaseFragment
import com.example.human.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private lateinit var mAuth: FirebaseAuth

    override fun viewCreated() {
        mAuth = FirebaseAuth.getInstance()

        listeners()
    }

    private fun listeners() {
        binding.apply {
            btnSignUp.setOnClickListener {
                authRegister()
            }

            tvSignIn.setOnClickListener {
                navigateLogIn()
            }
        }
    }

    private fun authRegister() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "field is empty!!!", Toast.LENGTH_SHORT).show()
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        navigateLogIn()
                    } else {
                        Toast.makeText(context, "error!!!", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun navigateLogIn(){
        findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLogInFragment())
    }
}

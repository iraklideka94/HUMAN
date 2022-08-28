package com.example.human.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.human.`typealias`.Inflater


abstract class BaseFragment<VB : ViewBinding>(private val inflater: Inflater<VB>) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    abstract fun viewCreated()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.inflater.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
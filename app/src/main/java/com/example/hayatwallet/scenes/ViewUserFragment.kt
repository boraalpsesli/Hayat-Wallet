package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentViewUserBinding


class ViewUserFragment : Fragment() {
    private lateinit var binding:FragmentViewUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewUserBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ViewUserFragment()
            }

}
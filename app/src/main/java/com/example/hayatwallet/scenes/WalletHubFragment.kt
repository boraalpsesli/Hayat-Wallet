package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentLoginBinding
import com.example.hayatwallet.databinding.FragmentWalletHubBinding

class WalletHubFragment : Fragment() {
    private lateinit var binding:FragmentWalletHubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWalletHubBinding.inflate(layoutInflater)
        return binding.root    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WalletHubFragment()
    }
}
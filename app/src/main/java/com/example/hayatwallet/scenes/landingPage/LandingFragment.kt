package com.example.hayatwallet.scenes.landingPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hayatwallet.databinding.FragmentLandingBinding
import com.example.hayatwallet.scenes.login.LoginFragmentDirections

class LandingFragment : Fragment() {

    private lateinit var binding:FragmentLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RegisteredButton.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.toLoginActivity()
            )
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LandingFragment()
    }
}
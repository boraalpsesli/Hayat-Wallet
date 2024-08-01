package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentLoginBinding
import com.example.hayatwallet.databinding.FragmentTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator


class TabLayoutFragment : Fragment() {
        private lateinit var binding:FragmentTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabLayoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
    }
    private fun setupViewPager() {
        val adapter =ViewPageAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tablayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Ana Sayfa"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_home)
                }
                1 -> {
                    tab.text = "Kampanyalar"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_campaign)
                }
                2 -> {
                    tab.text = "Profil"
                    tab.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_profile)
                }
            }
        }.attach()
    }

    companion object {


        @JvmStatic
        fun newInstance() =
            TabLayoutFragment()
    }
}
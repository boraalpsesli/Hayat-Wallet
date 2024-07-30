package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentLoginBinding
import com.example.hayatwallet.databinding.FragmentTabLayoutBinding




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
        val adapter = ViewPageAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        binding.homeTxt.setOnClickListener {
            currentTab()
           // binding.homeTxt.background = resources.getDrawable(R.color.grey,resources.newTheme())
            binding.viewPager.currentItem = 0
        }

        binding.campaingTxt.setOnClickListener {
            currentTab()
         //   binding.campaingTxt.background = resources.getDrawable(R.color.grey,resources.newTheme())
            binding.viewPager.currentItem = 1
        }

        binding.personTxt.setOnClickListener {
            currentTab()
            //binding.personTxt.background = resources.getDrawable(R.color.grey,resources.newTheme())
            binding.viewPager.currentItem = 2
        }
    }
    fun currentTab(){
        binding.homeTxt.background = resources.getDrawable(R.color.white,resources.newTheme())
        binding.campaingTxt.background = resources.getDrawable(R.color.white,resources.newTheme())
        binding.personTxt.background = resources.getDrawable(R.color.white,resources.newTheme())
    }
    companion object {


        @JvmStatic
        fun newInstance() =
            TabLayoutFragment()
    }
}
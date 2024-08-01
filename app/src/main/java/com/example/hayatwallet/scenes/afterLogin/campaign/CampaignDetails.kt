package com.example.hayatwallet.scenes.afterLogin.campaign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.hayatwallet.databinding.FragmentCampaignDetailsBinding

class CampaignDetails : Fragment() {
    private lateinit var binding:FragmentCampaignDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding=FragmentCampaignDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.CampaignDetailTitle.text=arguments?.getString("title")
        Glide.with(binding.imageView3.context).load(arguments?.getString("imageUrl")).into(binding.imageView3)
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            CampaignDetails()
}}
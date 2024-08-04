package com.example.hayatwallet.scenes.afterLogin.campaign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.databinding.FragmentCampaignFragementBinding
import com.example.hayatwallet.scenes.afterLogin.campaign.adapter.CampaignAdapter
import com.example.hayatwallet.scenes.afterLogin.campaign.viewModel.CampaignViewModel


class CampaignFragement : Fragment() {
        private lateinit var binding:FragmentCampaignFragementBinding
        private val viewModel: CampaignViewModel by viewModels()
        private lateinit var campaignAdapter: CampaignAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentCampaignFragementBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.CampaignRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        campaignAdapter = CampaignAdapter(emptyList())
        recyclerView.adapter = campaignAdapter
        viewModel.campaigns.observe(viewLifecycleOwner, Observer { campaigns->
            campaignAdapter=CampaignAdapter(campaigns)
            recyclerView.adapter=campaignAdapter
        })
        viewModel.getData()

    }
    companion object {

        @JvmStatic
        fun newInstance() =
            CampaignFragement()
    }
}
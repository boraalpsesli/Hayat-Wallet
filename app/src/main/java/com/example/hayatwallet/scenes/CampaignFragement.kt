package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentCampaignFragementBinding
import com.example.hayatwallet.network.response.CampaignItemView


class CampaignFragement : Fragment() {
        private lateinit var binding:FragmentCampaignFragementBinding
        private val viewModel:CampaignViewModel by viewModels()
        private var data=mutableListOf<CampaignItemView>()


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
        Thread {
            viewModel.getData { campaigns ->
                activity?.runOnUiThread {
                    binding.CampaignRecyclerView.layoutManager=LinearLayoutManager(context)
                    binding.CampaignRecyclerView.adapter=CampaignAdapter(campaigns) }

            }
        }.start()

    }
    companion object {

        @JvmStatic
        fun newInstance() =
            CampaignFragement()
    }
}
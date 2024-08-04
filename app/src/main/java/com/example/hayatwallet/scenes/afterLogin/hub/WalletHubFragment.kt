package com.example.hayatwallet.scenes.afterLogin.hub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentWalletHubBinding
import com.example.hayatwallet.network.response.TransactionHistoryData
import com.example.hayatwallet.scenes.afterLogin.campaign.viewModel.CampaignViewModel
import com.example.hayatwallet.scenes.afterLogin.hub.adapter.CampaignSliderAdapter
import com.example.hayatwallet.scenes.afterLogin.transaction.adapter.TransactionHistoryAdapter

class WalletHubFragment : Fragment() {
    private lateinit var binding:FragmentWalletHubBinding
    private lateinit var data:MutableList<TransactionHistoryData>
    private val viewModel: CampaignViewModel by viewModels()

    private var transactionAdapter= TransactionHistoryAdapter(3,arrayListOf())
    private var cAdapt=CampaignSliderAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private fun setupRecyclerView(){
        binding.TransactionRecycler.layoutManager=LinearLayoutManager(context)
        binding.TransactionRecycler.adapter=transactionAdapter
        binding.campaignRecyclerMain.layoutManager=LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.campaignRecyclerMain.adapter=cAdapt
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWalletHubBinding.inflate(layoutInflater)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        val companies = mutableListOf(
            TransactionHistoryData("Google"),
            TransactionHistoryData(
            "Apple"),
            TransactionHistoryData("Microsoft"),
            TransactionHistoryData("Amazon"),
            TransactionHistoryData("Facebook"),
            TransactionHistoryData("Tesla"),
        )
        data=companies
        transactionAdapter.updateData(data)
        var isExpanded=false
        binding.ExpandRecycler.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("companyName" ,data as ArrayList<*>)
            }
         findNavController().navigate(R.id.toFullTransactionHistory,bundle)
        }
        viewModel.campaigns.observe(viewLifecycleOwner, Observer { campaigns->
            cAdapt= CampaignSliderAdapter(campaigns)
            binding.campaignRecyclerMain.adapter=cAdapt
        })
        viewModel.getData()
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WalletHubFragment()
    }
}
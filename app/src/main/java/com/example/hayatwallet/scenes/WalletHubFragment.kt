package com.example.hayatwallet.scenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.FragmentLoginBinding
import com.example.hayatwallet.databinding.FragmentWalletHubBinding
import com.example.hayatwallet.network.response.TransactionHistoryData

class WalletHubFragment : Fragment() {
    private lateinit var binding:FragmentWalletHubBinding
    private lateinit var data:List<TransactionHistoryData>
    private var transactionAdapter=TransactionHistoryAdapter(3,arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private fun setupRecyclerView(){
        binding.TransactionRecycler.layoutManager=LinearLayoutManager(context)
        binding.TransactionRecycler.adapter=transactionAdapter
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
        val companies = listOf(
            "Google",
            "Apple",
            "Microsoft",
            "Amazon",
            "Facebook",
            "Tesla",
            "Netflix",
            "Adobe",
            "Intel",
            "IBM"
        )
        data=companies.map { TransactionHistoryData(it) }
        transactionAdapter.updateData(data)
        var isExpanded=false
        binding.ExpandRecycler.setOnClickListener {
            transactionAdapter.updateMaxItems(isExpanded)
            isExpanded=!isExpanded
        transactionAdapter.notifyDataSetChanged()}
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WalletHubFragment()
    }
}
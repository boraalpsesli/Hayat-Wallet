package com.example.hayatwallet.scenes.afterLogin.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hayatwallet.databinding.FragmentFullTransactionHistoryBinding
import com.example.hayatwallet.network.response.TransactionHistoryData
import com.example.hayatwallet.scenes.afterLogin.transaction.adapter.TransactionHistoryAdapter

class FullTransactionHistory : Fragment() {
    private lateinit var binding:FragmentFullTransactionHistoryBinding
    private var transactionAdapter= TransactionHistoryAdapter(100,arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFullTransactionHistoryBinding.inflate(layoutInflater)
        return binding.root
    }
    private fun setupRecyclerView(){
        binding.wholeRecycler.layoutManager= LinearLayoutManager(context)
        binding.wholeRecycler.adapter=transactionAdapter
        binding.wholeRecycler.addItemDecoration(
            DividerItemDecoration(context,LinearLayoutManager.VERTICAL)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        var list= emptyList<TransactionHistoryData>()
        arguments?.let{
            list=it.getSerializable("companyName") as ArrayList<TransactionHistoryData>
            transactionAdapter.updateData(list)


        }
        }
    companion object {

        @JvmStatic
        fun newInstance() =
            FullTransactionHistory()

    }
}
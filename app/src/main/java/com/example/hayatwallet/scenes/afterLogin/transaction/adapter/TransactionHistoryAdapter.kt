package com.example.hayatwallet.scenes.afterLogin.transaction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hayatwallet.databinding.TransactionHistoryRowBinding
import com.example.hayatwallet.network.response.TransactionHistoryData
import kotlin.math.min

class TransactionHistoryAdapter(private var maxItemCount:Int,private var historyList:List<TransactionHistoryData>):RecyclerView.Adapter<TransactionHistoryAdapter.HistoryHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val binding=TransactionHistoryRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryHolder(binding)

    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.bind(historyList[historyList.size-position-1])
    }

    override fun getItemCount(): Int {
       return min(historyList.size,maxItemCount)
    }
    fun updateData(newData: List<TransactionHistoryData>) {
        // Update the adapter's data and notify the change
        historyList = newData
        notifyDataSetChanged()
    }
    fun updateMaxItems(isMax:Boolean){
        if(!isMax)
        maxItemCount=historyList.size+1
        else
            maxItemCount=3
    }
    class HistoryHolder(private var binding:TransactionHistoryRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:TransactionHistoryData){
            binding.CompanyName.text=item.companyName
        }
    }
}
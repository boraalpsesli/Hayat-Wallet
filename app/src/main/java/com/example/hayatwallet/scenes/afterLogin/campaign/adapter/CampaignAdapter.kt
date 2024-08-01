package com.example.hayatwallet.scenes.afterLogin.campaign.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.CampaignCardRowBinding
import com.example.hayatwallet.network.response.CampaignItemView

class CampaignAdapter(private val campaignList:List<CampaignItemView>):RecyclerView.Adapter<CampaignAdapter.CampaignHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignHolder {
            val binding=CampaignCardRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CampaignHolder(binding)
        }

    override fun onBindViewHolder(holder: CampaignHolder, position: Int) {
        holder.bind(campaignList[position])

    }

    override fun getItemCount(): Int {
        return campaignList.size
    }
    class CampaignHolder(private var binding: CampaignCardRowBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(item:CampaignItemView){
                binding.CampaignTitle.text=item.title
                Glide.with(binding.imageView2.context).load(item.imageUrl).into(binding.imageView2)
                binding.button.setOnClickListener {
                    val bundle = Bundle().apply {
                        putString("title", item.title)
                        putString("imageUrl", item.imageUrl)
                    }

                    Navigation.findNavController(it).navigate(R.id.toCampaignDetails,bundle) }
            }
    }
}
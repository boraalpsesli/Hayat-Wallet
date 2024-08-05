package com.example.hayatwallet.scenes.afterLogin.hub.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hayatwallet.R
import com.example.hayatwallet.databinding.CampaignCardRowBinding
import com.example.hayatwallet.databinding.CampaignSliderRowBinding
import com.example.hayatwallet.network.response.CampaignItemView
import com.example.hayatwallet.scenes.afterLogin.campaign.adapter.CampaignAdapter

class CampaignSliderAdapter(private val campaignList:List<CampaignItemView>):
    RecyclerView.Adapter<CampaignSliderAdapter.CHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CHolder {
        val binding= CampaignSliderRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CHolder(binding)
    }

    override fun onBindViewHolder(holder: CHolder, position: Int) {
        holder.bind(campaignList[position])

    }

    override fun getItemCount(): Int {
        return campaignList.size
    }
    class CHolder(private var binding: CampaignSliderRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: CampaignItemView){
            Glide.with(binding.campaignImg.context).load(item.imageUrl).into(binding.campaignImg)
            binding.CardItem.setOnClickListener{
                val bundle = Bundle().apply {
                    putString("title", item.title)
                    putString("imageUrl", item.imageUrl)
                }
                Navigation.findNavController(it).navigate(R.id.toCampaignDetails,bundle)
            }
            }
        }
    }

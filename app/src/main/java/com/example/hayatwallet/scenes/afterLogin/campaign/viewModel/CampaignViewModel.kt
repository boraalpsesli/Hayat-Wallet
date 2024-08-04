package com.example.hayatwallet.scenes.afterLogin.campaign.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hayatwallet.network.response.CampaignItemView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class CampaignViewModel : ViewModel() {

    private val _campaigns = MutableLiveData<List<CampaignItemView>>()
    val campaigns: LiveData<List<CampaignItemView>> get() = _campaigns

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val campaigns = fetchCampaigns()
                _campaigns.postValue(campaigns)
            } catch (e: Exception) {
                // Handle the error accordingly, e.g., post a value to an error LiveData
                e.printStackTrace()
            }
        }
    }

    private fun fetchCampaigns(): List<CampaignItemView> {
        val campaigns = mutableListOf<CampaignItemView>()
        val doc = Jsoup.connect("https://www.hayatfinans.com.tr/kendim-icin-kampanyalar").get()
        val container = doc.body()
        val cards = container.getElementsByClass("card h-100")

        for (element in cards) {
            val card: Element? = element.getElementsByClass("card h-100").first()
            val imageUrl = card?.getElementsByTag("img")?.first()?.attr("data-src")
            val title = card?.getElementsByClass("card-title")?.first()?.text()
            val fullUrl = "https://www.hayatfinans.com.tr$imageUrl"
            if (title != null && imageUrl != null) {
                val campaign = CampaignItemView(title, fullUrl)
                campaigns.add(campaign)
            }
        }
        return campaigns
    }
}

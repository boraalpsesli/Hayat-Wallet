package com.example.hayatwallet.scenes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.network.response.CampaignItemView
import org.jsoup.Jsoup

class CampaignViewModel:ViewModel() {
    fun getData(callback: (List<CampaignItemView>) -> Unit) {

        var campaigns = mutableListOf<CampaignItemView>()

        val doc = Jsoup.connect("https://www.hayatfinans.com.tr/kendim-icin-kampanyalar").get()
        val container = doc.body()
        val cards = container.getElementsByClass("card h-100")

        for (element in cards) {
            val card = element.getElementsByClass("card h-100")
            val imageUrl = card.first()?.getElementsByTag("img")?.first()?.attr("data-src")
            val title = card.first()?.getElementsByClass("card-title")?.first()?.text()
            val fullUrl = "https://www.hayatfinans.com.tr$imageUrl"
            val campaign = CampaignItemView(title,fullUrl)
            campaigns.add(campaign)
        }
        callback.invoke(campaigns)
    }
}
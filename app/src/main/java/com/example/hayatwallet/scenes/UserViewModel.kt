package com.example.hayatwallet.scenes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.network.Network
import com.example.hayatwallet.network.TokenManager
import com.example.hayatwallet.network.response.getUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    val userData= MutableLiveData<getUserResponse?>()
    fun getUser(){
        val token= TokenManager.token
        Network.service.getUser("Bearer $token").enqueue(object : Callback<getUserResponse> {
            override fun onResponse(
                call: Call<getUserResponse>,
                response: Response<getUserResponse>
            ) {
                if(response.isSuccessful && response.body()!=null){
                    val temp=response.body()
                    userData.postValue(temp)
                }
            }

            override fun onFailure(call: Call<getUserResponse>, t: Throwable) {
                println("Error")
            }
        })
    }
}
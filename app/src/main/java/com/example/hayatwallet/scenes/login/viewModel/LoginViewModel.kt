package com.example.hayatwallet.scenes.login.viewModel

import android.annotation.SuppressLint
import android.media.session.MediaSession.Token
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.network.Network
import com.example.hayatwallet.network.TokenManager
import com.example.hayatwallet.network.response.LoginRequest
import com.example.hayatwallet.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Response

class LoginViewModel:ViewModel() {
    val loginData=MutableLiveData<LoginResponse?>()
     fun login(uName:String?,password:String){
         val user=LoginRequest(uName,password)
         Network.service.login(user).enqueue(object:retrofit2.Callback<LoginResponse>{
             @SuppressLint("SuspiciousIndentation")
             override fun onResponse(
                 call: Call<LoginResponse>,
                 response: Response<LoginResponse>) {
                 if(response.isSuccessful && response.body()!=null){
                     val temp=response.body()?.item?.token
                        loginData.postValue(response.body())
                     TokenManager.token=temp
                     Log.e("token","${TokenManager.token}")
                     }
                 else {
                        loginData.postValue(response.body())
                 }
             }

             override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                 println("Error")

                           }
         })
     }

}
package com.example.hayatwallet.scenes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hayatwallet.network.Network
import com.example.hayatwallet.network.response.Item
import com.example.hayatwallet.network.response.LoginRequest
import com.example.hayatwallet.network.response.LoginResponse
import retrofit2.Call
import retrofit2.Response

class LoginViewModel:ViewModel() {
    val userData=MutableLiveData<LoginResponse?>()


     fun login(uName:String,password:String){
         val user=LoginRequest(uName,password)
         Network.service.login(user).enqueue(object:retrofit2.Callback<LoginResponse>{
             override fun onResponse(
                 call: Call<LoginResponse>,
                 response: Response<LoginResponse>) {
                 if(response.isSuccessful && response.body()!=null){
                        userData.postValue(response.body())
                     }
                 else {
                        userData.postValue(response.body())
                 }
             }

             override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                 println("Error")

                           }
         })
     }
}
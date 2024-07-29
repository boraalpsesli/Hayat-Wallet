package com.example.hayatwallet.network

import com.example.hayatwallet.network.response.LoginRequest
import com.example.hayatwallet.network.response.LoginResponse
import com.example.hayatwallet.network.response.getUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("User/signin")
    fun login(@Body userData:LoginRequest): Call<LoginResponse>
    @GET("user/viewuser")
    fun getUser(@Header("Authorization") token:String):Call<getUserResponse>

}
package com.example.hayatwallet.network

import com.example.hayatwallet.network.response.LoginRequest
import com.example.hayatwallet.network.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("User/signin")
    fun login(@Body userData:LoginRequest): Call<LoginResponse>
}
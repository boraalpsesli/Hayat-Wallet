package com.example.hayatwallet.network.response

data class LoginResponse(val item:Item?)

data class Item(val token:String?,val isSuccess:Boolean?)

package com.example.hayatwallet.network.response

data class LoginResponse(val item:Item?,val errorMessage:String?)

data class Item(val token:String?,val isSuccess:Boolean?)

package com.example.hayatwallet.network.response

data class getUserResponse(val item:getUserItem)

data class getUserItem(val userName:String,val firstName:String,val lastName:String,val email:String)

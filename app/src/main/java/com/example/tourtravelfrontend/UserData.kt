package com.example.tourtravelfrontend

import com.google.gson.annotations.SerializedName

data class UserData (
    @SerializedName("username") val username:String,
    @SerializedName("email") val email:String,
    @SerializedName("password") val password:String
)
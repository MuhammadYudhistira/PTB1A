package com.ptb1a.PojoModels

import com.google.gson.annotations.SerializedName

data class LogoutResponse(

    @field:SerializedName("message")
    val message: String? = null
)
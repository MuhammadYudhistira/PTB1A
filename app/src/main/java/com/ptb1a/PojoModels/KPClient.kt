package com.ptb1a.PojoModels

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KPClient {
    @FormUrlEncoded
    @POST("/api/login/")
    fun Login(@Field("username") username:String, @Field("password") password:String):Call<LoginResponse>

    @GET("/api/me")
    fun profile():Call<User>

    @POST("/api/me/update")
    fun updatepass()
}

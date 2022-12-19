package com.ptb1a.PojoModels

import android.util.JsonToken
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface KPClient {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username:String, @Field("password") password:String):Call<LoginResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<User>

    @POST("/api/me/update")
    fun updateProfile(@Header("Authorization") token:String)

    @POST("/api/logout")
    fun logout(@Header("Authorization") token: String):Call<User>
}

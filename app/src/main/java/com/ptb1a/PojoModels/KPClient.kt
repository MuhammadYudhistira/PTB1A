package com.ptb1a.PojoModels

import com.ptb1a.models.DetailKP
import com.ptb1a.models.InternshipsItem
import com.ptb1a.models.ListMahasiswaBimbingan
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface KPClient {
    @FormUrlEncoded
    @POST("/api/login/")
    fun login(@Field("username") username:String,
              @Field("password") password:String
    ):Call<LoginResponse>

    @GET("/api/me")
    fun profile(@Header("Authorization") token:String):Call<User>

    @FormUrlEncoded
    @POST("/api/me/update")
    fun updateProfile(
        @Header("Authorization") token:String,
        @Field("name") name:String,
        @Field("email") email:String
    ):Call<UpdateProfileResponse>

    @FormUrlEncoded
    @POST("/api/password")
    fun updatePassword(
        @Header("Authorization")token: String,
        @Field("old_password") old_password:String,
        @Field("new_password") new_password:String,
        @Field("confirm_password") confirm_password:String
    ):Call<UpdatePasswordResponse>

    @POST("/api/logout")
    fun logout(@Header("Authorization") token: String):Call<LogoutResponse>

    @GET("/api/internship-students")
    fun getListMahasiswaBimbingan(@Header("Authorization") token: String):Call<ListMahasiswaBimbingan>

    @GET("/api/internship-students")
    fun getInternshipsItem(@Header("Authorization") token: String):Call<InternshipsItem>

    @GET("/api/my-internship/{id}")
    fun getDetailKP(@Header("Authorization") token: String,
                    @Path("id") id:Int):Call<DetailKP>

}

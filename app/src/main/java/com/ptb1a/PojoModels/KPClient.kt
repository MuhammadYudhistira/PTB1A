package com.ptb1a.PojoModels

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.JsonToken
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
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

    //3 API UAS
    @GET("/api/my-internship/{id}/logbook")
    fun listlogbook(@Header("Authorization") token: String,
                    @Path("id") id:Int
    ):Call<ListLogbookResponse>

    @PATCH("/api/internship-students/{id}/logbook/{id_logbook}")
    fun updateLogbook(@Header("Authorization") token: String,
                      @Path("id") id: Int,
                      @Path("id_logbook") id_logbook:Int
    ):Call<UpdateLogbookResponse>

    @GET("/api/my-internship/{id}/logbook/{id_logbook}")
    fun detailLogbook(@Header("Authorization") token: String,
                      @Path("id") id: Int,
                      @Path("id_logbook") id_logbook: Int
    ):Call<DetailLogbookResponse>
}

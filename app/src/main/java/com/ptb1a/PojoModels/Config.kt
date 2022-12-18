package com.ptb1a.PojoModels

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Config {

    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return  okHttpClient
    }

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("http://ptb-api.husnilkamil.my.id")
            .addConverterFactory( GsonConverterFactory.create())
            .client(getInterceptor())
            .build()
    }

    fun getService() = getRetrofit().create(KPClient::class.java)

}
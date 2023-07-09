package com.hkinfo.allcountrydetails.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        val BASE_URL = "https://restcountries.com/"

        lateinit var retrofit: Retrofit

        fun getApiClient(): Retrofit {

            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }
    }
}
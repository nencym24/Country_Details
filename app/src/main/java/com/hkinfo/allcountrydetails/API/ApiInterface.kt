package com.hkinfo.allcountrydetails.API

import com.hkinfo.allcountrydetails.Model.CountryModal
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

        @GET("all")

        fun getCountry() : Call<List<CountryModal>>
}
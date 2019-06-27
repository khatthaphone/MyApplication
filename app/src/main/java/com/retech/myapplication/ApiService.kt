package com.retech.myapplication

import com.retech.myapplication.model.Rate
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("rates.json")
    fun getCurrencyRate(): Call<List<Rate>>
}
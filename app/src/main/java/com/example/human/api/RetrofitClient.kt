package com.example.human.api

import com.example.human.constants.Constants
import com.example.human.get.GetItems
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    val retrofitBuilder by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GetItems::class.java)
    }

}
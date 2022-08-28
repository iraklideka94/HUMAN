package com.example.human.get

import com.example.human.constants.Constants
import com.example.human.model.ClothesDataClass
import retrofit2.Response
import retrofit2.http.GET


interface GetItems {

    @GET(Constants.END_POINT)
    suspend fun items(): Response<ClothesDataClass>

}
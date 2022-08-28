package com.example.human.fragments.home

import androidx.lifecycle.ViewModel
import com.example.human.api.RetrofitClient
import com.example.human.model.ClothesDataClass
import com.example.human.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeViewModel : ViewModel() {

    fun getItems(): Flow<Resource<ClothesDataClass.Content>> = flow {
        val answerFromServer = RetrofitClient.retrofitBuilder.items()
        val response: Resource<ClothesDataClass.Content> = when {
            answerFromServer.isSuccessful -> {
                Resource.Success(list = answerFromServer.body()!!.content)
            }
            else -> {
                Resource.Error(errorMsg = answerFromServer.errorBody()!!.string())
            }
        }
        emit(response)
    }
}
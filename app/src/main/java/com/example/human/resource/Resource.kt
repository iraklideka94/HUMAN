package com.example.human.resource

sealed class Resource<T> {
    data class Success<T>(val list: List<T>) : Resource<T>()
    data class Error<T>(val errorMsg: String) : Resource<T>()
}
package com.aravind.mvvm.data.api

import com.aravind.mvvm.data.model.UserModel
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : List<UserModel>
}
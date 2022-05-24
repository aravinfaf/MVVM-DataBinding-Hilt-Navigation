package com.aravind.mvvm.data.repository

import com.aravind.mvvm.data.api.ApiService
import com.aravind.mvvm.data.model.UserModel
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getUsers() : List<UserModel>{
       return apiService.getUsers()
    }
}
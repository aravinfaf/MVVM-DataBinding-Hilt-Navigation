package com.aravind.mvvm.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aravind.mvvm.data.model.UserModel
import com.aravind.mvvm.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewmodel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private var users : MutableLiveData<List<UserModel>> = MutableLiveData()
    val mUserResponse : LiveData<List<UserModel>> = users

    fun getUsers(){
        viewModelScope.launch {
           users.value =  repository.getUsers()
        }
    }
}
package com.aravind.mvvm.di

import com.aravind.mvvm.data.api.ApiService
import com.aravind.mvvm.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataRepositoryModule {

    @Provides
    fun provideRepository(apiService: ApiService) : MainRepository{
        return MainRepository(apiService)
    }
}
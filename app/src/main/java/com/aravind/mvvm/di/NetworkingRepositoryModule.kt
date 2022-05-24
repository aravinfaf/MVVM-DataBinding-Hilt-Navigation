package com.aravind.mvvm.di

import com.aravind.mvvm.Utils
import com.aravind.mvvm.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkingRepositoryModule {

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
         return OkHttpClient().newBuilder()
             .addInterceptor(loggingInterceptor).build()
    }
    @Provides
    fun provideRetrofitInstance(client: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun apiService(retrofit: Retrofit) : ApiService{
       return retrofit.create(ApiService::class.java)
    }
}
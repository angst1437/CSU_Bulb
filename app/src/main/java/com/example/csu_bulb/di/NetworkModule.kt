package com.example.csu_bulb.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.csu_bulb.data.api.BulbApi
import retrofit2.converter.scalars.ScalarsConverterFactory


@Module
class NetworkModule {
    @Provides
    fun provideBulbService(): BulbApi =
        Retrofit.Builder()
            .baseUrl("http://195.133.53.179:1337")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BulbApi::class.java)
}
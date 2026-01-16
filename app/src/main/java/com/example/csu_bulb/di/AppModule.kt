package com.example.csu_bulb.di

import dagger.Module

@Module(
    includes = [
        AppBindsModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
class AppModule

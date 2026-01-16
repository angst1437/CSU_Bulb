package com.example.csu_bulb.di

import com.example.csu_bulb.presenter.MainFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun inject(fragment: MainFragment)
}
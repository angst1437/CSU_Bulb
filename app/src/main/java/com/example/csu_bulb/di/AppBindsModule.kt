package com.example.csu_bulb.di

import dagger.Binds
import dagger.Module
import com.example.csu_bulb.data.repository.BulbRepository
import com.example.csu_bulb.data.repository.BulbRepositoryImpl
import com.example.csu_bulb.domain.SwitchBulbStateUseCase
import com.example.csu_bulb.domain.SwitchBulbStateUseCaseImpl
import com.example.csu_bulb.domain.SetBulbBrightnessUseCase
import com.example.csu_bulb.domain.SetBulbBrightnessUseCaseImpl
import com.example.csu_bulb.domain.SetBulbColorUseCase
import com.example.csu_bulb.domain.SetBulbColorUseCaseImpl

@Module
interface AppBindsModule {

    @Binds
    fun bindBulbRepository(impl: BulbRepositoryImpl): BulbRepository

    @Binds
    fun bindSwitchBulbStateUseCase(impl: SwitchBulbStateUseCaseImpl): SwitchBulbStateUseCase

    @Binds
    fun bindSetBulbBrightnessUseCase(impl: SetBulbBrightnessUseCaseImpl): SetBulbBrightnessUseCase

    @Binds
    fun bindSetBulbColorUseCase(impl: SetBulbColorUseCaseImpl): SetBulbColorUseCase
}
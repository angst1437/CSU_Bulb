package com.example.csu_bulb.domain

interface SwitchBulbStateUseCase {
    suspend operator fun invoke(state: Boolean): Result<Boolean>

    suspend fun getBulbState(): Result<Boolean>
}
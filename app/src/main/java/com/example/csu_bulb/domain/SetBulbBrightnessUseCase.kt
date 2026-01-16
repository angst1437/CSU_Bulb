package com.example.csu_bulb.domain

interface SetBulbBrightnessUseCase {
    suspend operator fun invoke(level: Int): Result<Boolean>
}
package com.example.csu_bulb.domain


interface SetBulbColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean>

    suspend fun getAvailableColors(): Result<List<String>>
}
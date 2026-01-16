package com.example.csu_bulb.domain

import com.example.csu_bulb.data.repository.BulbRepository
import javax.inject.Inject

class SetBulbColorUseCaseImpl @Inject constructor(
    private val repository: BulbRepository
): SetBulbColorUseCase {
    override suspend fun invoke(color: String): Result<Boolean> {
        return repository.setBulbColor(color)
    }

    override suspend fun getAvailableColors(): Result<List<String>> {
        return repository.getAvailableColors()
    }
}
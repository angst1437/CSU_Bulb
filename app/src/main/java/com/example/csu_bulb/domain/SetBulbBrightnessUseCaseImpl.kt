package com.example.csu_bulb.domain

import com.example.csu_bulb.data.repository.BulbRepository
import javax.inject.Inject

class SetBulbBrightnessUseCaseImpl @Inject constructor(
    private val bulbRepository: BulbRepository
) : SetBulbBrightnessUseCase {
    override suspend fun invoke(level: Int): Result<Boolean> {
        return bulbRepository.setBulbBrightness(level)
    }
}
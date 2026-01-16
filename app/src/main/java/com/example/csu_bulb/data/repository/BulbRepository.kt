package com.example.csu_bulb.data.repository


interface BulbRepository {

    suspend fun switchBulbState(state: Boolean): Result<Boolean>
    suspend fun getBulbState(): Result<Boolean>

    suspend fun setBulbBrightness(level: Int): Result<Boolean>

    suspend fun setBulbColor(color: String): Result<Boolean>

    suspend fun getAvailableColors(): Result<List<String>>
}
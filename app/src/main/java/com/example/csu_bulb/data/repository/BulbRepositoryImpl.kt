package com.example.csu_bulb.data.repository

import android.util.Log
import com.example.csu_bulb.data.api.BulbApi
import javax.inject.Inject

class BulbRepositoryImpl @Inject constructor(
    private val api: BulbApi
) : BulbRepository {

    override suspend fun switchBulbState(state: Boolean): Result<Boolean> {
        return try {
            val command = if (state) "on" else "off"
            Log.d("BulbRepositoryImpl", "Bulb switched $command")
            val response = api.switchBulbState(command)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Ошибка АПИ, код: ${response.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun getBulbState(): Result<Boolean> {
        return try {
            val response = api.getBulbState()
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Ошибка АПИ, код: ${response.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun setBulbBrightness(level: Int): Result<Boolean> {
        return try {
            val response = api.setBulbBrightness(level)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Ошибка АПИ, код: ${response.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun setBulbColor(color: String): Result<Boolean> {
        return try {
            val response = api.setBulbColor(color)
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Ошибка АПИ, код: ${response.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAvailableColors(): Result<List<String>> {
        return try {
            val response = api.getAvailableBulbColorNames()
            if (response.isSuccessful) Result.success(response.body()!!)
            else Result.failure(Exception("Ошибка АПИ, код: ${response.code()}"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}
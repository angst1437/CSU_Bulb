package com.example.csu_bulb.data.api

import com.example.csu_bulb.data.dto.BulbBrightness
import com.example.csu_bulb.data.dto.BulbColor
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface BulbApi {

    @POST("/state/{action}")
    suspend fun switchBulbState(@Path("action") action: String): Response<Boolean>

    @GET("/state/")
    suspend fun getBulbState(): Response<Boolean>

    @GET("/color/")
    suspend fun getAvailableBulbColors(): Response<List<BulbColor>>

    @POST("/color/")
    suspend fun setBulbColor(@Query("color") color: String): Response<Boolean>

    @GET("/color/names_only")
    suspend fun getAvailableBulbColorNames(): Response<List<String>>

    @GET("/color/current")
    suspend fun getCurrentBulbColor(): Response<BulbColor>

    @GET("/brightness/")
    suspend fun getAvailableBulbBrightnessLevels(): Response<BulbBrightness>

    @POST("/brightness/")
    suspend fun setBulbBrightness(@Query("level") level: Int): Response<Boolean>

    @GET("/brightness/current")
    suspend fun getCurrentBulbBrightness(): Response<Int>
}
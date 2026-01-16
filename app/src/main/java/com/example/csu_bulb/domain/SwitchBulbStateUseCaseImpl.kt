package com.example.csu_bulb.domain

import android.util.Log
import com.example.csu_bulb.data.repository.BulbRepository
import javax.inject.Inject

class SwitchBulbStateUseCaseImpl @Inject constructor (
    private val repository: BulbRepository
) : SwitchBulbStateUseCase {

    override suspend fun invoke(state: Boolean): Result<Boolean> {
        return repository.switchBulbState(state)
    }

    override suspend fun getBulbState(): Result<Boolean> {
        val state = repository.getBulbState()
        Log.d("SwitchBulbStateUseCaseImpl", "getBulbState: $state")
        return state
        }
}

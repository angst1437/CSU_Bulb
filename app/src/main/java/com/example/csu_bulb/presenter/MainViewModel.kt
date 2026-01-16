package com.example.csu_bulb.presenter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.csu_bulb.UiState
import com.example.csu_bulb.domain.SwitchBulbStateUseCase
import com.example.csu_bulb.domain.SetBulbBrightnessUseCase
import com.example.csu_bulb.domain.SetBulbColorUseCase
import com.example.csu_bulb.toUiState
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val switchBulbStateUseCase: SwitchBulbStateUseCase,
    private val setBulbBrightnessUseCase: SetBulbBrightnessUseCase,
    private val setBulbColorUseCase: SetBulbColorUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState<Boolean>>(UiState.Idle)
    val uiState: LiveData<UiState<Boolean>> = _uiState

    private var currentState = true

    private val _availableColors = MutableLiveData<List<String>>(emptyList())
    val availableColors: LiveData<List<String>> = _availableColors

    private val _selectedColor = MutableLiveData<String>()
    val selectedColor: LiveData<String> = _selectedColor
    init {
        Log.d("MainViewModel: ", "init")
        fetchBulbState()
        loadAvailableColors()
    }

    private fun loadAvailableColors() {
        viewModelScope.launch {
            val result = setBulbColorUseCase.getAvailableColors()
            if (result.isSuccess) {
                _availableColors.value = result.getOrNull() ?: emptyList()
                _selectedColor.value = result.getOrNull()?.firstOrNull()
            } else {
                Log.e("MainViewModel", "Ошибка загрузки цветов", result.exceptionOrNull())
            }
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            _selectedColor.value = color
            val result = setBulbColorUseCase(color)
            if (result.isSuccess && result.getOrNull() == true) {
                Log.d("MainViewModel", "Цвет изменён: $color")
            }
        }
    }

    private fun fetchBulbState() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = switchBulbStateUseCase.getBulbState()
            _uiState.value = result.toUiState()
            if (result.isSuccess) {
                Log.d("fetchBulbState: ", result.getOrNull().toString())
                currentState = result.getOrNull() ?: false
            }
        }
    }


    fun toggleBulb() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = switchBulbStateUseCase(!currentState)
            _uiState.value = result.toUiState()
            if (result.isSuccess) {
                currentState = !currentState
            }
        }
    }

    fun setBrightness(level: Int) {
        viewModelScope.launch {
            val result = setBulbBrightnessUseCase(level)
            if (result.isSuccess) {
                Log.d("MainViewModel", "Яркость установлена: $level")
            } else {
                Log.e("MainViewModel", "Ошибка установки яркости", result.exceptionOrNull())
            }
        }
    }

}
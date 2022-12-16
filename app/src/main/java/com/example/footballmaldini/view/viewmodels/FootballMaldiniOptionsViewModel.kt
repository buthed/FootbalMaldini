package com.example.footballmaldini.view.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.footballmaldini.data.SharedPrefernceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FootballMaldiniOptionsViewModel @Inject constructor(
    private val sharedPrefernceRepository: SharedPrefernceRepository
): ViewModel() {

    var footballMaldiniMusicMode by mutableStateOf(true)
    var footballMaldiniSoundsMode by mutableStateOf(true)

    init {
        footballMoldiniPrefMusicGet()
        footballMoldiniPrefSoundsGet()
    }

    private fun footballMoldiniPrefMusicSave() {
        sharedPrefernceRepository.footballMoldiniPrefMusicSave(footballMaldiniMusicMode)
    }

    private fun footballMoldiniPrefSoundsSave() {
        sharedPrefernceRepository.footballMoldiniPrefSoundsSave(footballMaldiniSoundsMode)
    }

    private fun footballMoldiniPrefMusicGet() {
        footballMaldiniMusicMode = sharedPrefernceRepository.footballMoldiniPrefMusicGet()
    }

    private fun footballMoldiniPrefSoundsGet() {
        footballMaldiniSoundsMode = sharedPrefernceRepository.footballMoldiniPrefSoundsGet()
    }

    fun footballMoldiniSavePreferences() {
        footballMoldiniPrefMusicSave()
        footballMoldiniPrefSoundsSave()
    }
}
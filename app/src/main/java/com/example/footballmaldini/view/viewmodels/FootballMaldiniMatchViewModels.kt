package com.example.footballmaldini.view.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballmaldini.data.MediaPlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FootballMaldiniMatchViewModels @Inject constructor(
    private val mediaPlayerRepository: MediaPlayerRepository
): ViewModel() {

    var footballMaldiniChoosedGoal by mutableStateOf(0)

    var footballMaldiniRandomGoal by mutableStateOf(true)

    var footballMaldiniBallIsThrow by mutableStateOf(false)

    var footballMaldiniReadyForThrow by mutableStateOf(true)

    var footballMaldiniBalance by mutableStateOf(2000)

    var footballMaldiniBet by mutableStateOf(200)

    fun footballMaldiniBetReset() {
        footballMaldiniBet = 0
    }

    fun footballMaldiniBetX2() {
        if ((footballMaldiniBet * 2)<=footballMaldiniBalance) footballMaldiniBet *= 2
    }

    fun footballMaldiniMinus() {
        if ((footballMaldiniBet-100)>=0) footballMaldiniBet-=100
    }

    fun footballMaldiniPlus() {
        if ((footballMaldiniBet+100)<=footballMaldiniBalance) footballMaldiniBet+=100
    }

    fun footballMaldiniAddMoney() {
        if (footballMaldiniBalance==0) footballMaldiniBalance+=1000
    }

    fun footballMaldiniThrowBall() {
        if (footballMaldiniBet!=0) {
            if (footballMaldiniReadyForThrow) {
                footballMaldiniBallIsThrow = true
                footballMaldiniReadyForThrow = false
                footballMaldiniBalance-=footballMaldiniBet
                footballMaldiniRandomGoal()
            }
        }
    }

    fun footballMaldiniCheckHit(): Boolean {
        footballMaldiniChoosedGoal = 0
        viewModelScope.launch {
            delay(500)
            footballMaldiniBallIsThrow = false
            delay(2000)
            footballMaldiniReadyForThrow = true
        }
        return if (footballMaldiniRandomGoal) {
            footballMaldiniBalance+=footballMaldiniBet*2
            mediaPlayerRepository.playFootballMaldiniWinSound()
            true
        } else {
            mediaPlayerRepository.playFootballMaldiniMissSound()
            false
        }
    }


    fun footballMaldiniRandomGoal() {
        footballMaldiniRandomGoal = Random.nextBoolean()
    }
}
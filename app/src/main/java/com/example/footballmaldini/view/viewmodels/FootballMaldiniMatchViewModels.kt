package com.example.footballmaldini.view.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FootballMaldiniMatchViewModels @Inject constructor(

): ViewModel() {

    var footballMaldiniChoosedGoal by mutableStateOf(0)

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
}
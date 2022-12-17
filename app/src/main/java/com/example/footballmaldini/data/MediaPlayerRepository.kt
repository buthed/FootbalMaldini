package com.example.footballmaldini.data

import android.media.MediaPlayer
import javax.inject.Inject
import javax.inject.Named

class MediaPlayerRepository @Inject constructor(

    @Named("WinSound")
    private val footballMaldiniWinSound: MediaPlayer,

    @Named("MissSound")
    private val footballMaldiniMissSound: MediaPlayer,

    private val sharedPrefernceRepository: SharedPrefernceRepository

) {

    fun playFootballMaldiniWinSound() {
        if (sharedPrefernceRepository.footballMoldiniPrefSoundsGet()) footballMaldiniWinSound.start()
    }

    fun playFootballMaldiniMissSound() {
        if (sharedPrefernceRepository.footballMoldiniPrefSoundsGet()) footballMaldiniMissSound.start()
    }
}
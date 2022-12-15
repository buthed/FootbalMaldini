package com.example.footballmaldini.data

import android.media.MediaPlayer
import javax.inject.Inject
import javax.inject.Named

class MediaPlayerRepository @Inject constructor(

    @Named("WinSound")
    private val footballMaldiniWinSound: MediaPlayer,

    @Named("MissSound")
    private val footballMaldiniMissSound: MediaPlayer,

) {

    fun playFootballMaldiniWinSound() = footballMaldiniWinSound.start()

    fun playFootballMaldiniMissSound() = footballMaldiniMissSound.start()
}
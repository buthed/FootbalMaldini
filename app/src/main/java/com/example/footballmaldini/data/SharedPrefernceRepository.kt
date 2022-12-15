package com.example.footballmaldini.data

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Named

class SharedPrefernceRepository @Inject constructor(

    @Named("football_maldini_preference_balance")
    private val footballMaldiniPrefBalance: SharedPreferences,

    @Named("football_maldini_preference_music")
    private val footballMaldiniPrefMusic: SharedPreferences,

    @Named("football_maldini_preference_sounds")
    private val footballMaldiniPrefSounds: SharedPreferences,
) {

    fun footballMoldiniPrefBalanceSave(newBalance: Int) {
        footballMaldiniPrefBalance
            .edit()
            .putInt("football_maldini_preference_balance", newBalance)
            .apply()
    }
    fun footballMoldiniPrefBalanceGet() {
        footballMaldiniPrefBalance.getInt("football_maldini_preference_balance", 2000)
    }

    fun footballMoldiniPrefMusicSave() {
        footballMaldiniPrefMusic
            .edit()
            .putBoolean("football_maldini_preference_music", true)
            .apply()
    }

    fun footballMoldiniPrefMusicGet(newMusicMode: Boolean) {
        footballMaldiniPrefMusic.getBoolean("football_maldini_preference_music", true)
    }

    fun footballMoldiniPrefSoundsSave(newMusicMode: Boolean) {
        footballMaldiniPrefSounds
            .edit()
            .putBoolean("football_maldini_preference_sounds", newMusicMode)
            .apply()
    }

    fun footballMoldiniPrefSoundsGet() {
        footballMaldiniPrefSounds.getBoolean("football_maldini_preference_sounds", true)
    }
}
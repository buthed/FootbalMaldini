package com.example.footballmaldini.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.footballmaldini.R

class FootballMaldiniBackgroundMusicService : Service() {
    private lateinit var footballMaldiniMediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }

    override fun onCreate() {
        super.onCreate()
        footballMaldiniMediaPlayer = MediaPlayer.create(this, R.raw.football_maldini_background)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (this.getSharedPreferences("football_maldini_preference_music", Context.MODE_PRIVATE)
                .getBoolean("football_maldini_preference_music",true)){
            footballMaldiniMediaPlayer.start()
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        footballMaldiniMediaPlayer.pause()
    }
}
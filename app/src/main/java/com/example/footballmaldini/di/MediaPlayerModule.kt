package com.example.footballmaldini.di

import android.content.Context
import android.media.MediaPlayer
import com.example.footballmaldini.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MediaPlayerModule {

    @Provides
    @Singleton
    @Named("WinSound")
    fun footballMaldiniWinSound(@ApplicationContext context: Context): MediaPlayer {
        return MediaPlayer.create(context, R.raw.football_maldini_win)
    }

    @Provides
    @Singleton
    @Named("MissSound")
    fun footballMaldiniMissSound(@ApplicationContext context: Context): MediaPlayer {
        return MediaPlayer.create(context, R.raw.football_maldini_miss)
    }
}
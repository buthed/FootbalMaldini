package com.example.footballmaldini.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModule {

    @Provides
    @Singleton
    @Named("football_maldini_preference_balance")
    fun provideFootballMaldiniBalance(@ApplicationContext context: Context) : SharedPreferences  {
        return context.getSharedPreferences("football_maldini_preference_balance", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    @Named("football_maldini_preference_music")
    fun provideFootballMaldiniMusic(@ApplicationContext context: Context) : SharedPreferences {
        return context.getSharedPreferences("football_maldini_preference_music", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    @Named("football_maldini_preference_sounds")
    fun provideFootballMaldiniSounds(@ApplicationContext context: Context) : SharedPreferences {
        return context.getSharedPreferences("football_maldini_preference_sounds", Context.MODE_PRIVATE)
    }
}
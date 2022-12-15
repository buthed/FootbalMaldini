package com.example.footballmaldini

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.footballmaldini.navigation.FootballMaldiniNavHost
import com.example.footballmaldini.view.ui.theme.FootballMaldiniTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballMaldiniTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val footballMaldiniNavHostController = rememberNavController()
                    FootballMaldiniNavHost(footballMaldiniNavHostController)
                }
            }
        }
    }
}
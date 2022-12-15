package com.example.footballmaldini.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.footballmaldini.R


@Composable
fun FootballMaldiniBackgroundMenu() {
    Image(painter = painterResource(id = R.drawable.background01), contentDescription = "",
        Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
}

@Composable
fun FootballMaldiniBackground() {
    Image(painter = painterResource(id = R.drawable.background02), contentDescription = "",
        Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
}
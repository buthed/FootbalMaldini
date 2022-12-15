package com.example.footballmaldini.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.footballmaldini.R

@Composable
fun FootballMaldiniNavigateButtons(toMenu: () -> Unit, toOptions: () -> Unit) {
    Box(Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.TopStart) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Image(painter = painterResource(id = R.drawable.back), contentDescription = "",
                Modifier.size(40.dp).clickable(onClick = toMenu))
            Image(painter = painterResource(id = R.drawable.options02), contentDescription = "",
                Modifier.size(40.dp).clickable(onClick = toOptions))
        }
    }
}
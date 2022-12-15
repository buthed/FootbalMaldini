package com.example.footballmaldini.view.components.match

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.footballmaldini.view.ui.theme.Typography

@Composable
fun FootballMaldiniResultText() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Row(Modifier.height(50.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Excellent!".uppercase(),
                style = Typography.h1, )
        }
    }
}
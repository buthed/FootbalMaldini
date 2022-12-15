package com.example.footballmaldini.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballmaldini.R
import com.example.footballmaldini.view.ui.theme.Typography

@Composable
fun FootballMaldiniBalanceTab(balance: Int) {
    Box(Modifier.fillMaxSize().padding(10.dp), contentAlignment = Alignment.TopEnd) {
        Box(Modifier
            .height(40.dp)
            .width(100.dp), contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(id = R.drawable.balance), contentDescription = "",
                Modifier
                    .height(35.dp)
                    .width(140.dp))
            Text(text = balance.toString(), Modifier.padding(start = 25.dp), style = Typography.body1,
                textAlign = TextAlign.Center)
        }
    }
}
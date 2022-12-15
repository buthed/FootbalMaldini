package com.example.footballmaldini.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.footballmaldini.R
import com.example.footballmaldini.view.components.FootballMaldiniBackgroundMenu
import com.example.footballmaldini.view.ui.theme.FootballMaldiniTheme

@Composable
fun FootballMaldiniMenu(navHostController: NavHostController) {
    FootballMaldiniBackgroundMenu()

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart) {
        Column(Modifier.padding(start = 120.dp).width(150.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(painter = painterResource(id = R.drawable.play), contentDescription = "",
                Modifier.width(150.dp).height(50.dp)
                    .clickable { navHostController.navigate("footballMaldiniMatch") })
            Image(painter = painterResource(id = R.drawable.options01), contentDescription = "",
                Modifier.width(150.dp).height(50.dp)
                    .clickable { navHostController.navigate("footballMaldiniOptions") })
            Image(painter = painterResource(id = R.drawable.exit), contentDescription = "",
                Modifier.width(150.dp).height(50.dp)
                    .clickable { navHostController.navigate("footballMaldiniExit") })
        }
    }
}

@Preview(device = Devices.PIXEL_4, widthDp = 720, heightDp = 360)
@Composable
fun FootballMaldiniMenuPreview() {
    val navHostController = rememberNavController()

    FootballMaldiniTheme() {
        FootballMaldiniMenu(navHostController)
    }
}
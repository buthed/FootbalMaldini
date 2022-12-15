package com.example.footballmaldini.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.footballmaldini.R
import com.example.footballmaldini.view.components.*
import com.example.footballmaldini.view.components.match.FootballMaldiniBetTab
import com.example.footballmaldini.view.components.match.FootballMaldiniResultText
import com.example.footballmaldini.view.components.match.FootballMaldiniThrowButton
import com.example.footballmaldini.view.ui.theme.FootballMaldiniTheme

@Composable
fun FootballMaldiniMatch() {
    FootballMaldiniBackground()

    FootballMaldiniNavigateButtons(
        toMenu = {},
        toOptions = {}
    )
    FootballMaldiniBalanceTab(1250)

    FootballMaldiniBetTab()

    FootballMaldiniResultText()

    FootballMaldiniThrowButton{ }

    ConstraintLayout(FootballMaldiniMatchConstraintSet(),
        Modifier
            .fillMaxHeight()
            .width(300.dp)
            .padding(top = 50.dp, bottom = 85.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.gates), contentDescription = "",
            Modifier.layoutId("fmMatchGates"))
        Box(Modifier.layoutId("fmMatchGoal1"), contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.select), contentDescription = "",
                Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.goal), contentDescription = "",
                Modifier.size(33.dp))
        }
        Box(Modifier.layoutId("fmMatchGoal2"), contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.select), contentDescription = "",
                Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.goal), contentDescription = "",
                Modifier.size(33.dp))
        }
        Box(Modifier.layoutId("fmMatchGoal3"), contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.select), contentDescription = "",
                Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.goal), contentDescription = "",
                Modifier.size(33.dp))
        }
        Box(Modifier.layoutId("fmMatchGoal4"), contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.select), contentDescription = "",
                Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.goal), contentDescription = "",
                Modifier.size(33.dp))
        }
        Box(Modifier.layoutId("fmMatchGoal5"), contentAlignment = Alignment.Center){
            Image(painter = painterResource(id = R.drawable.select), contentDescription = "",
                Modifier.size(40.dp))
            Image(painter = painterResource(id = R.drawable.goal), contentDescription = "",
                Modifier.size(33.dp))
        }
    }
}

@Composable
fun FootballMaldiniMatchConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val fmMatchGates = (createRefFor("fmMatchGates"))
        val fmMatchGoal1 = (createRefFor("fmMatchGoal1"))
        val fmMatchGoal2= (createRefFor("fmMatchGoal2"))
        val fmMatchGoal3= (createRefFor("fmMatchGoal3"))
        val fmMatchGoal4= (createRefFor("fmMatchGoal4"))
        val fmMatchGoal5= (createRefFor("fmMatchGoal5"))

        constrain(fmMatchGates) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(fmMatchGoal1) {
            top.linkTo(fmMatchGates.top)
            start.linkTo(fmMatchGates.start, margin = 10.dp)
        }
        constrain(fmMatchGoal2) {
            top.linkTo(fmMatchGates.top)
            end.linkTo(fmMatchGates.end, margin = 10.dp)
        }
        constrain(fmMatchGoal3) {
            top.linkTo(fmMatchGoal1.bottom)
            bottom.linkTo(fmMatchGoal5.top)
            start.linkTo(fmMatchGates.start)
            end.linkTo(fmMatchGates.end)
        }
        constrain(fmMatchGoal4) {
            bottom.linkTo(fmMatchGates.bottom, margin = 60.dp)
            start.linkTo(fmMatchGates.start, margin = 10.dp)
        }
        constrain(fmMatchGoal5) {
            bottom.linkTo(fmMatchGates.bottom, margin = 60.dp)
            end.linkTo(fmMatchGates.end, margin = 10.dp)
        }
    }
}

@Preview(device = Devices.PIXEL_4, widthDp = 720, heightDp = 360)
@Composable
fun FootballMaldiniMatchPreview() {
    FootballMaldiniTheme() {
        FootballMaldiniMatch()
    }
}
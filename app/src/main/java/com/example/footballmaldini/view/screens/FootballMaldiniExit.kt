package com.example.footballmaldini.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.footballmaldini.R
import com.example.footballmaldini.view.components.FootballMaldiniBackground
import com.example.footballmaldini.view.components.FootballMaldiniNavigateButtons
import com.example.footballmaldini.view.ui.theme.FootballMaldiniTheme
import com.example.footballmaldini.view.ui.theme.Typography

@Composable
fun FootballMaldiniExit() {
    FootballMaldiniBackground()

    FootballMaldiniNavigateButtons(
        toMenu = {},
        toOptions = {}
    )
    ConstraintLayout(FootballMaldiniExitConstraintSet(), Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bg_tab), contentDescription = "",
            Modifier.layoutId("fmExitBg"))
        Image(painter = painterResource(id = R.drawable.exit), contentDescription = "",
            Modifier
                .layoutId("fmExitTitle")
                .width(100.dp)
                .height(50.dp))
        Image(painter = painterResource(id = R.drawable.close), contentDescription = "",
            Modifier.layoutId("fmExitClose").size(30.dp).clickable {  })
        Column(Modifier.layoutId("fmExitContent"),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.exit_question).uppercase(), style = Typography.h1)
            Row() {
                Image(painter = painterResource(id = R.drawable.yes), contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .clickable { })
                Spacer(Modifier.width(50.dp))
                Image(painter = painterResource(id = R.drawable.no), contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .clickable { })
            }
        }
    }
}

@Composable
fun FootballMaldiniExitConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val fmExitBg = (createRefFor("fmExitBg"))
        val fmExitTitle = (createRefFor("fmExitTitle"))
        val fmExitContent = (createRefFor("fmExitContent"))
        val fmExitClose = (createRefFor("fmExitClose"))

        constrain(fmExitBg) {
            top.linkTo(parent.top,)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(fmExitTitle) {
            top.linkTo(fmExitBg.top,)
            bottom.linkTo(fmExitBg.top)
            start.linkTo(fmExitBg.start)
            end.linkTo(fmExitBg.end)
        }
        constrain(fmExitContent) {
            top.linkTo(fmExitTitle.bottom,)
            bottom.linkTo(fmExitBg.bottom)
            start.linkTo(fmExitBg.start)
            end.linkTo(fmExitBg.end)
        }
        constrain(fmExitClose) {
            top.linkTo(fmExitBg.top)
            bottom.linkTo(fmExitBg.top)
            start.linkTo(fmExitBg.end)
        }
    }
}

@Preview(device = Devices.PIXEL_4, widthDp = 720, heightDp = 360)
@Composable
fun FootballMaldiniExitScreenPreview() {
    FootballMaldiniTheme() {
        FootballMaldiniExit()
    }
}
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
fun FootballMaldiniOptions() {
    FootballMaldiniBackground()

    FootballMaldiniNavigateButtons(
        toMenu = {},
        toOptions = {}
    )

    ConstraintLayout(FootballMaldiniOptionsConstraintSet(), Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bg_tab), contentDescription = "",
            Modifier.layoutId("fmOptionsBg"))
        Image(painter = painterResource(id = R.drawable.options01), contentDescription = "",
            Modifier
                .layoutId("fmOptionsTitle")
                .width(100.dp)
                .height(50.dp))
        Image(painter = painterResource(id = R.drawable.close), contentDescription = "",
            Modifier.layoutId("fmOptionsClose").size(30.dp).clickable {  })
        Column(Modifier.layoutId("fmOptionsContent"),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.music).uppercase(), style = Typography.h1)
            Row() {
                Image(painter = painterResource(id = R.drawable.on), contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .clickable { })
                Spacer(Modifier.width(50.dp))
                Image(painter = painterResource(id = R.drawable.off), contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .clickable { })
            }
            Spacer(Modifier.height(10.dp))
            Text(text = stringResource(id = R.string.sounds).uppercase(), style = Typography.h1)
            Row() {
                Image(painter = painterResource(id = R.drawable.on), contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .clickable { })
                Spacer(Modifier.width(50.dp))
                Image(painter = painterResource(id = R.drawable.off), contentDescription = "",
                    Modifier
                        .size(40.dp)
                        .clickable { })
            }
        }
    }
}

@Composable
fun FootballMaldiniOptionsConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val fmOptionsBg = (createRefFor("fmOptionsBg"))
        val fmOptionsTitle = (createRefFor("fmOptionsTitle"))
        val fmOptionsContent = (createRefFor("fmOptionsContent"))
        val fmOptionsClose = (createRefFor("fmOptionsClose"))

        constrain(fmOptionsBg) {
            top.linkTo(parent.top,)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(fmOptionsTitle) {
            top.linkTo(fmOptionsBg.top,)
            bottom.linkTo(fmOptionsBg.top)
            start.linkTo(fmOptionsBg.start)
            end.linkTo(fmOptionsBg.end)
        }
        constrain(fmOptionsContent) {
            top.linkTo(fmOptionsTitle.bottom,)
            bottom.linkTo(fmOptionsBg.bottom, margin = 20.dp)
            start.linkTo(fmOptionsBg.start)
            end.linkTo(fmOptionsBg.end)
        }
        constrain(fmOptionsClose) {
            top.linkTo(fmOptionsBg.top)
            bottom.linkTo(fmOptionsBg.top)
            start.linkTo(fmOptionsBg.end)
        }
    }
}

@Preview(device = Devices.PIXEL_4, widthDp = 720, heightDp = 360)
@Composable
fun FootballMaldiniOptionsPreview() {
    FootballMaldiniTheme() {
        FootballMaldiniOptions()
    }
}
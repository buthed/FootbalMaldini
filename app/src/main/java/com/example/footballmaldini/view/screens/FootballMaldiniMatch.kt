package com.example.footballmaldini.view.screens

import android.widget.Toast
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.footballmaldini.R
import com.example.footballmaldini.view.components.*
import com.example.footballmaldini.view.components.match.FootballMaldiniBetTab
import com.example.footballmaldini.view.components.match.FootballMaldiniResultText
import com.example.footballmaldini.view.components.match.FootballMaldiniThrowButton
import com.example.footballmaldini.view.ui.theme.FootballMaldiniTheme
import com.example.footballmaldini.view.ui.theme.Typography
import com.example.footballmaldini.view.viewmodels.FootballMaldiniMatchViewModels
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun FootballMaldiniMatch(navHostController: NavHostController) {
    val viewmodel = hiltViewModel<FootballMaldiniMatchViewModels>()
    val context = LocalContext.current
    val coroutine = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val footballMaldiniWidth = with(LocalDensity.current) {configuration.screenWidthDp.dp.roundToPx()}
    val footballMaldiniHeight = with(LocalDensity.current) {configuration.screenHeightDp.dp.roundToPx()}

    val toastTargetNoTarget = Toast.makeText(context, "No target selected", Toast.LENGTH_LONG)
    val toastAddMoney = Toast.makeText(context, "To add money, click on the balance tab", Toast.LENGTH_LONG)
    val toastBetLowerBalance = Toast.makeText(context, "The bet cannot be less than the balance", Toast.LENGTH_LONG)

    var footballMaldiniGoal1 by remember { mutableStateOf(Offset.Zero) }
    var footballMaldiniGoal2 by remember { mutableStateOf(Offset.Zero) }
    var footballMaldiniGoal3 by remember { mutableStateOf(Offset.Zero) }
    var footballMaldiniGoal4 by remember { mutableStateOf(Offset.Zero) }
    var footballMaldiniGoal5 by remember { mutableStateOf(Offset.Zero) }

    var footballMaldiniResultTitle by remember { mutableStateOf("") }
    var footballMaldiniResultMoney by remember { mutableStateOf("") }

    val footballMaldiniBallDefaultOffset by remember { mutableStateOf(IntOffset(footballMaldiniWidth/8,footballMaldiniHeight/10*8)) }
    var footballMaldiniBallThrowOffset by remember { mutableStateOf(IntOffset(0,0)) }


    FootballMaldiniBackground()

    FootballMaldiniNavigateButtons(
        toMenu = { navHostController.popBackStack() },
        toOptions = { navHostController.navigate("footballMaldiniOptions")}
    )
    FootballMaldiniBalanceTab(viewmodel.footballMaldiniBalance){
        viewmodel.footballMaldiniAddMoney()
    }

    FootballMaldiniBetTab(viewmodel)

    FootballMaldiniResultText(footballMaldiniResultTitle)

    FootballMaldiniThrowButton{ if (viewmodel.footballMaldiniChoosedGoal == 0) toastTargetNoTarget.show()
        else { if (viewmodel.footballMaldiniBalance == 0) { toastAddMoney.show()
            } else { if(viewmodel.footballMaldiniBet>viewmodel.footballMaldiniBalance) toastBetLowerBalance.show()
                else viewmodel.footballMaldiniThrowBall()
            }
        }
    }

    ConstraintLayout(footballMaldiniMatchConstraintSet(),
        Modifier
            .fillMaxSize()
            .width(300.dp)
            .padding(top = 50.dp, bottom = 85.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.gates), contentDescription = "",
            Modifier.layoutId("fmMatchGates"))
        Box(Modifier
            .layoutId("fmMatchGoal1")
            .size(40.dp)
            .onGloballyPositioned { footballMaldiniGoal1 = it.positionInWindow() }
            .clickable {
                viewmodel.footballMaldiniChoosedGoal = 1
                footballMaldiniBallThrowOffset =
                    IntOffset(footballMaldiniGoal1.x.roundToInt(),
                        footballMaldiniGoal1.y.roundToInt())
            },
            contentAlignment = Alignment.Center
        ){
            GoalTarget(viewmodel.footballMaldiniChoosedGoal == 1)
        }
        Box(Modifier
            .layoutId("fmMatchGoal2")
            .size(40.dp)
            .onGloballyPositioned { footballMaldiniGoal2 = it.positionInWindow() }
            .clickable {
                viewmodel.footballMaldiniChoosedGoal = 2
                footballMaldiniBallThrowOffset =
                    IntOffset(footballMaldiniGoal2.x.roundToInt(),
                        footballMaldiniGoal2.y.roundToInt())
            },
            contentAlignment = Alignment.Center
        ){
            GoalTarget(viewmodel.footballMaldiniChoosedGoal == 2)
        }
        Box(Modifier
            .layoutId("fmMatchGoal3")
            .size(40.dp)
            .onGloballyPositioned { footballMaldiniGoal3 = it.positionInWindow() }
            .clickable {
                viewmodel.footballMaldiniChoosedGoal = 3
                footballMaldiniBallThrowOffset =
                    IntOffset(footballMaldiniGoal3.x.roundToInt(),
                        footballMaldiniGoal3.y.roundToInt())
            },
            contentAlignment = Alignment.Center
        ){
            GoalTarget(viewmodel.footballMaldiniChoosedGoal == 3)
        }
        Box(Modifier
            .layoutId("fmMatchGoal4")
            .size(40.dp)
            .onGloballyPositioned { footballMaldiniGoal4 = it.positionInWindow() }
            .clickable {
                viewmodel.footballMaldiniChoosedGoal = 4
                footballMaldiniBallThrowOffset =
                    IntOffset(footballMaldiniGoal4.x.roundToInt(),
                        footballMaldiniGoal4.y.roundToInt())
            },
            contentAlignment = Alignment.Center
        ){
            GoalTarget(viewmodel.footballMaldiniChoosedGoal == 4)
        }
        Box(Modifier
            .layoutId("fmMatchGoal5")
            .size(40.dp)
            .onGloballyPositioned { footballMaldiniGoal5 = it.positionInWindow() }
            .clickable {
                viewmodel.footballMaldiniChoosedGoal = 5
                footballMaldiniBallThrowOffset =
                    IntOffset(footballMaldiniGoal5.x.roundToInt(),
                        footballMaldiniGoal5.y.roundToInt())
            },
            contentAlignment = Alignment.Center
        ){
            GoalTarget(viewmodel.footballMaldiniChoosedGoal == 5)
        }
        Text(text = footballMaldiniResultMoney.uppercase(),  Modifier.layoutId("fmPlusMoney"),
            style = Typography.h1)
    }
    val positionBallX by animateIntAsState(
        targetValue =  if (viewmodel.footballMaldiniBallIsThrow) footballMaldiniBallThrowOffset.x-20   else footballMaldiniBallDefaultOffset.x,
        tween(2000, 0, FastOutSlowInEasing))

    val positionBallY by animateIntAsState(
        targetValue =  if (viewmodel.footballMaldiniBallIsThrow) footballMaldiniBallThrowOffset.y-100  else footballMaldiniBallDefaultOffset.y,
        tween(2000, 0, FastOutSlowInEasing),
        finishedListener = {
            if (!viewmodel.footballMaldiniReadyForThrow) {
                if (viewmodel.footballMaldiniCheckHit()) {
                    footballMaldiniResultTitle = context.getString(R.string.excelent)
                    footballMaldiniResultMoney = "+${viewmodel.footballMaldiniBet*2}"
                } else {
                    footballMaldiniResultTitle = context.getString(R.string.miss)
                    footballMaldiniResultMoney = ""
                }
            }
            coroutine.launch {
                delay(2000)
                footballMaldiniResultTitle = ""
                footballMaldiniResultMoney = ""
            }
        })

    Image(painter = painterResource(id = R.drawable.ball02), contentDescription = "",
        Modifier
            .size(50.dp)
            .absoluteOffset { IntOffset(positionBallX, positionBallY) })
}

@Composable
private fun GoalTarget(selected: Boolean) {
    if (selected) {
        Image(painter = painterResource(id = R.drawable.select), contentDescription = "",
            Modifier.size(40.dp))
    }
    Image(painter = painterResource(id = R.drawable.goal), contentDescription = "",
        Modifier.size(33.dp))
}

@Composable
fun footballMaldiniMatchConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val fmMatchGates = (createRefFor("fmMatchGates"))
        val fmMatchGoal1 = (createRefFor("fmMatchGoal1"))
        val fmMatchGoal2= (createRefFor("fmMatchGoal2"))
        val fmMatchGoal3= (createRefFor("fmMatchGoal3"))
        val fmMatchGoal4= (createRefFor("fmMatchGoal4"))
        val fmMatchGoal5= (createRefFor("fmMatchGoal5"))
        val fmPlusMoney = (createRefFor("fmPlusMoney"))
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
        constrain(fmPlusMoney) {
            top.linkTo(fmMatchGoal5.bottom, margin = 15.dp)
            bottom.linkTo(fmMatchGates.bottom)
            start.linkTo(fmMatchGates.start)
            end.linkTo(fmMatchGates.end)
        }
    }
}

@Preview(device = Devices.PIXEL_4, widthDp = 720, heightDp = 360)
@Composable
fun FootballMaldiniMatchPreview() {
    val navHostController = rememberNavController()

    FootballMaldiniTheme() {
        FootballMaldiniMatch(navHostController)
    }
}
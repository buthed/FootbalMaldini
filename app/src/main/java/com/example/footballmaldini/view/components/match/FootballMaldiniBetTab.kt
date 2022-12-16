package com.example.footballmaldini.view.components.match

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.footballmaldini.R
import com.example.footballmaldini.view.ui.theme.Typography
import com.example.footballmaldini.view.viewmodels.FootballMaldiniMatchViewModels

@Composable
fun FootballMaldiniBetTab(viewmodel: FootballMaldiniMatchViewModels) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.bet01), contentDescription = "",
                Modifier
                    .height(80.dp)
                    .width(300.dp), contentScale = ContentScale.FillBounds)
            Column(Modifier
                .height(80.dp)
                .width(300.dp)
                .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(text = stringResource(id = R.string.bet).uppercase(), style = Typography.h1)
                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Image(painter = painterResource(id = R.drawable.reset), contentDescription = "",
                        Modifier.size(30.dp).clickable { viewmodel.footballMaldiniBetReset() })
                    Image(painter = painterResource(id = R.drawable.minus), contentDescription = "",
                        Modifier.size(20.dp).clickable { viewmodel.footballMaldiniMinus() })
                    Box(Modifier.height(30.dp).width(110.dp),
                        contentAlignment = Alignment.Center) {
                        Image(painter = painterResource(id = R.drawable.bet02), contentDescription = "",
                            Modifier.height(30.dp).width(120.dp), contentScale = ContentScale.FillBounds)
                        Text(text = viewmodel.footballMaldiniBet.toString(),Modifier.padding(top = 3.dp), style = Typography.h1)
                    }
                    Image(painter = painterResource(id = R.drawable.plus), contentDescription = "",
                        Modifier.size(20.dp).clickable { viewmodel.footballMaldiniPlus() })
                    Image(painter = painterResource(id = R.drawable.x2), contentDescription = "",
                        Modifier.size(30.dp).clickable { viewmodel.footballMaldiniBetX2() })
                }
            }
        }
    }
}
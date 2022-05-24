package com.ahrenswett.pillminder.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahrenswett.pillminder.Screen
import com.ahrenswett.pillminder.classes.Bottle
import com.ahrenswett.pillminder.R

@Composable
fun MainScreen(navController: NavController, bottleList: List<Bottle>?) {
    remember { mutableStateOf(bottleList) }
    Column(Modifier.fillMaxSize(), Arrangement.SpaceEvenly) {
        if(bottleList?.isNotEmpty() == true){
            Card(
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(2.dp)
                    .weight(1f, true)
                    .clickable {
                        navController.navigate(Screen.ListReminderScreen.route)
                    }
            ){
                Column(
                    Modifier
                        .fillMaxSize(),
                    Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = stringResource(id = R.string.view_reminders_text),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Card(
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(2.dp)
                .weight(1f, true)
                .clickable {
                    navController.navigate(Screen.AddReminderScreen.route)
                }
        ){
            Column(
                Modifier
                    .fillMaxSize(),
                Arrangement.SpaceEvenly
            ) {
                Text(
                    text = stringResource(id = R.string.add_reminder),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

        }
    }
}
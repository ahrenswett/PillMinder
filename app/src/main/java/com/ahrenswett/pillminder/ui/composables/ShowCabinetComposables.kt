package com.ahrenswett.pillminder.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ahrenswett.pillminder.entities.Bottle
import com.ahrenswett.pillminder.entities.Cabinet
import java.util.*


//TODO: make this able to show multiple cabinets i.e. self, childs, and pets.




@Composable
fun ShowCabinetList(navController: NavController, cabinet: Cabinet){
    LazyColumn{
        items(cabinet.bottleList){
            ReminderInfo(bottle = it)
        }
    }
}

@Composable
fun ReminderInfo(bottle: Bottle){
//    val consumable = bottle.consumable

//    val type = consumable.type.name.lowercase().replaceFirstChar {
//        if (it.isLowerCase()) it.titlecase(Locale.getDefault())
//        else it.toString() }
//
//    val form = consumable.form.name.lowercase().replaceFirstChar {
//        if (it.isLowerCase()) it.titlecase(Locale.getDefault())
//        else it.toString() }

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(2.dp)) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp), Arrangement.SpaceEvenly) {
//            Text(text = "This Reminder is for a $type")
//            Text(text = "Name: ${consumable.name}")
//            Text(text = "Form: $form")
            Text(text = "Directions: ${bottle.prescription?.timesToTakePerDay} by mouth every 24 hours")
            Text(text = "Reminder start time: $")
        }
    }
}
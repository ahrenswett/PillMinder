package com.ahrenswett.pillminder

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahrenswett.pillminder.ui.composables.AddConsumableBottle
import com.ahrenswett.pillminder.ui.composables.MainScreen


@Composable
fun Navagation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController, null)
        }
//        composable(route = Screen.ListReminderScreen.route){
//            ShowCabinetList(navController = navController)
//        }
        composable(route = Screen.AddReminderScreen.route){
            AddConsumableBottle(navController = navController)
        }
    }
}
package com.ahrenswett.pillminder

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahrenswett.pillminder.Screen.*
import com.ahrenswett.pillminder.ui.composables.AddConsumable
import com.ahrenswett.pillminder.ui.composables.MainScreen
import com.ahrenswett.pillminder.ui.composables.ShowCabinet


@Composable
fun Navagation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route){
            MainScreen(navController = navController, bottleList = bottleList)
        }
        composable(route = Screen.ListReminderScreen.route){
            ShowCabinet(navController = navController,bottleList = bottleList)
        }
        composable(route = Screen.AddReminderScreen.route){
            AddConsumable(navController = navController,bottleList = bottleList)
        }
    }
}
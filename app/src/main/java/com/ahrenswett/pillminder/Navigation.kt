package com.ahrenswett.pillminder

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.ahrenswett.pillminder.ui.composables.AddConsumableBottle
import com.ahrenswett.pillminder.ui.composables.MainScreen
import com.ahrenswett.pillminder.util.Route


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.MainRoute.route){
        composable(route = Route.MainRoute.route){
            MainScreen(navController = navController, null)
        }
//        Navigation
        composable(route = Route.AddReminderRoute.route){
//            AddConsumableBottle(navController = navController)
        }
    }
}
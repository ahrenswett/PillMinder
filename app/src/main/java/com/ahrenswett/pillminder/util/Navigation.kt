package com.ahrenswett.pillminder

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ahrenswett.pillminder.ui.add_edit_bottle.AddEditBottleScreen
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetScreen
import com.ahrenswett.pillminder.ui.cabinet_view.CabinetViewScreen
import com.ahrenswett.pillminder.ui.composables.CabinetListScreen
import com.ahrenswett.pillminder.util.Route

//Documentation
//https://developer.android.com/jetpack/compose/navigation#nav-with-args

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.CABINET_LIST.route
    ){
        // Navigation to CabinetList
        composable(Route.CABINET_LIST.route){
            CabinetListScreen(
                onNavigate = {
                    navController.navigate(it.route)
                }
            )
        }
//******************************** Cabinet Navigation ********************************
        // Navigation to AddEditCabinet
        dialog(route = Route.ADD_EDIT_CABINET.route + "?cabinetID={cabinetID}",
            arguments = listOf(
                navArgument( name = "cabinetID"){
                    type = NavType.StringType
                    defaultValue = ""
                },

            )
        ){
            AddEditCabinetScreen(onPopBackStack = { navController.popBackStack()})
        }

        // Navigation to CabinetView
        composable(route = Route.CABINET_VIEW.route + "?cabinetID={cabinetID}",
            arguments = listOf(
                navArgument(name = "cabinetID"){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ){
            Log.i("Navigation", "CabinetView")
            CabinetViewScreen(
                onPopBackStack = { navController.popBackStack() },
                onNavigate = { navController.navigate(it.route) }
            )
        }

//*********************************** Bottle Navigation ***********************************

//        Navigate to AddEditBottle
//        composable(route = Route.ADD_EDIT_BOTTLE.route + "?cabinetID={cabinetID}",
//            arguments = listOf(
//                navArgument( name = "cabinetID"){
//                    Log.i("Navigation", "AddEditBottle")
//                    type = NavType.StringType
//                    defaultValue = ""
//                }
//            )
//        ){
//            Log.i("Navigation", "AddEditBottle")
//            AddEditBottleScreen(onPopBackStack = { navController.popBackStack() })
//        }

        dialog(route = Route.ADD_EDIT_BOTTLE.route +  "?cabinetID={cabinetID}?tabIndex={tabIndex}",
            arguments = listOf(
                navArgument(name = "cabinetID"){
                    Log.i("Navigation", "AddEditBottle")
                    type = NavType.StringType
                    defaultValue = ""
                },
                navArgument(name = "tabIndex"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            Log.i("Navigation", "AddEditBottle")
            AddEditBottleScreen(onPopBackStack = { navController.popBackStack() }, it.arguments)
        }


        // Navigate to BottleView
    }
}
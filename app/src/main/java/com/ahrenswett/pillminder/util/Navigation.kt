package com.ahrenswett.pillminder

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ahrenswett.pillminder.ui.add_edit_bottle.AddEditBottleScreen
import com.ahrenswett.pillminder.ui.add_edit_cabinet.AddEditCabinetScreen
import com.ahrenswett.pillminder.ui.cabinet_list.CabinetListViewModel
import com.ahrenswett.pillminder.ui.cabinet_view.CabinetViewScreen
//import com.ahrenswett.pillminder.ui.composables.AddConsumableBottle
import com.ahrenswett.pillminder.ui.composables.CabinetListScreen
import com.ahrenswett.pillminder.util.Route
import com.ahrenswett.pillminder.util.UiEvent
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


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

        // Navigation to AddEditCabinet
        composable(route = Route.ADD_EDIT_CABINET.route + "?cabinetID={cabinetID}",
            arguments = listOf(
                navArgument( name = "cabinetID"){
                    type = NavType.StringType
                    defaultValue = ""
                }
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
            CabinetViewScreen(onPopBackStack = {navController.popBackStack()})
        }

        // Navigate to AddEditBottle
        composable(route = Route.ADD_EDIT_BOTTLE.route + "?bottleID={bottleID",
            arguments = listOf(
                navArgument( name = "bottleID"){
                    type = NavType.StringType
                }
            )
        ){
            AddEditBottleScreen(onPopBackStack = { /*TODO*/ })
        }


        // Navigate to BottleView
    }
}
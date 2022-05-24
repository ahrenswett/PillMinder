package com.ahrenswett.pillminder

sealed class Screen(val route:String){
    object MainScreen : Screen("main_screen")
    object ListReminderScreen : Screen("list_screen")
    object AddReminderScreen : Screen("add_screen")
}

package com.ahrenswett.pillminder.util


sealed class Route(val route:String){
    object MainRoute : Route("main_screen")
    object ViewCabinet : Route("view_cabinet")
    object ListReminderRoute : Route("list_screen")
    object AddReminderRoute : Route("add_screen")
    object AddBottleToCabinet : Route("add_bottle")
}

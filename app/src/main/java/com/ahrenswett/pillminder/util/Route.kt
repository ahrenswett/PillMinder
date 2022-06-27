package com.ahrenswett.pillminder.util


sealed class Route(val route:String){
    object CABINET_LIST : Route("cabinet_list")
    object CABINET_VIEW : Route("cabinet_view")
    object ADD_EDIT_CABINET : Route("add_edit_cabinet")
    object ADD_EDIT_BOTTLE : Route("add_edit_bottle")
    object LIST_REMINDERS : Route("list_reminders")
    object ADD_REMINDER : Route("add_reminder")
}

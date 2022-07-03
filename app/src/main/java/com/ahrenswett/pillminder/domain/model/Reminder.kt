package com.ahrenswett.pillminder.domain.model


///* TODO: Time picker: allow users to choose a time they would like to be reminded and stop being reminded
//    Allow users to chose between single time and interval time as well a choose a reminder duration. A duration will remind only for x hours then log as missed.
//      interval time allows users to chose an initial reminder time and X number of other reminders spaced evenly across Y hours
//        for example:
//            a user takes the same pill 3 times a day and is awake from 6am - 10pm
//            they would like initial reminder at 7am and then every 6 hours so at 1pm and 7pm
//            do not remind after 10 pm is a failsafe
//            if the user takes the pill at 7pm, they would like to be reminded at 7pm and then every 6 hours after that
//     times converted to string and stored in database
//
// */
//
//class Reminder ( var reminderTimes : ArrayList<Time>, val endReminder : Time){
////TODO: reminder must show full screen over other apps until one of 2 options selected
//// it must ask if you have taken meds or not
//// if taken update database that it was taken and time taken
//// if not taken remind every x minutes until time to stop reminding or user says taken
//// if not taken by reminder stop time update database with missed dose
//
//
//
//}
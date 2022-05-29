package com.ahrenswett.pillminder.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ahrenswett.pillminder.entities.*
import com.ahrenswett.pillminder.type_converters.*
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList

@Composable
fun AddConsumableBottle(navController: NavController){

    var consumable = Consumable(
        name = "Depakote",
        supplementOrMedication = Type.MEDICATION,
        VolumePerUnit = 250F,
        form = Form.TABLET
    )

    var bottle = Bottle(
        consumableID = consumable.name + consumable.VolumePerUnit,
        expirationDate = Date(2022,12,28),
        startDate = Date(2022,5,9),
        prescription= Prescription(
            dose = Dose(1000, Measurement.MILLIGRAMS),
            timesToTakePerDay = 3,
            prescribingDoc = "Chee M."),
        measurement = Measurement.MILLIGRAMS,
        quantityInBottle = 270,
        reminder = Reminder(ArrayList(), Time(900))
    )
    Column() {

    }



// TODO
//    val consumable: Consumable,
//      name
//      type
//      VolumePerUnit
//      form
//    val prescription : Prescription?,
//          dose
//            amount
//            measurement
//        timesToTakePerDay
//        prescribingDoc
//    var measurement: Measurement?,
//        enum list
//    var reminder: Reminder?
//      define the class
//    var quantityInBottle: Int? = null,
//    val expirationDate : Date? = null,
//    var startDate : Date?
}
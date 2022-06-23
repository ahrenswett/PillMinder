package com.ahrenswett.pillminder.ui.add_edit_bottle

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.ahrenswett.pillminder.domain.model.Consumable
import kotlinx.serialization.Contextual

sealed class AddEditBottleEvent{
    data class OnNameChange(val consumableID : String) : AddEditBottleEvent()
    data class OnQuantityChange(val quantity : Int) :AddEditBottleEvent()
    /*TODO:
     * Add reminder picker events
     * Add measurement choices
     * Add prescription gathering information
     * calendar picker for Expiration Date
     * calendar picker for Start date
     */
    object OnSubmit : AddEditBottleEvent()
}

//data class Bottle(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo val bottleID : Int?,
//    @ColumnInfo val consumableID: String,
////    @Embedded var prescription : Prescription?,
////    @Embedded var measurement: Measurement?,
////    @Embedded var reminder: Reminder?,
//    @ColumnInfo var quantityInBottle: Int?,
//    @ColumnInfo @Contextual val expirationDate : String?,
//    @ColumnInfo @Contextual var startDate : String?,
//    @ColumnInfo val cabinetID: String

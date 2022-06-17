package com.ahrenswett.pillminder.domain.model

import androidx.room.*
import kotlinx.serialization.Serializable
//import com.ahrenswett.pillminder.type_converters.MeasurementTypeConverters
import java.util.*

@Entity(tableName = "bottles")
@Serializable
data class Bottle(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo val bottleID : Int?,
    @ColumnInfo val consumableID: String,
//    @Embedded var prescription : Prescription?,
//    @Embedded var measurement: Measurement?,
//    @Embedded var reminder: Reminder?,
    @ColumnInfo var quantityInBottle: Int?,
//    @ColumnInfo val expirationDate : Date?,
//    @ColumnInfo var startDate : Date?,
    @ColumnInfo val cabinetID: String
)


//enum class Measurement(){
//    MILLIGRAMS,
//    SCOOP,
//    GRAMS,
//    OZ,
//    TSP,
//    TBS;
//
//}
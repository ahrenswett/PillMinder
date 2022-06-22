package com.ahrenswett.pillminder.domain.model

import androidx.room.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

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
    @ColumnInfo @Contextual val expirationDate : String?,
    @ColumnInfo @Contextual var startDate : String?,
    @ColumnInfo val cabinetID: String
)
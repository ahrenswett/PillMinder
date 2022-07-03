package com.ahrenswett.pillminder.domain.model

import androidx.room.*
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Entity(tableName = "bottles")
//@Serializable
data class Bottle(
    @PrimaryKey(autoGenerate = true) val bottleID: Int,
    @ColumnInfo var consumableID: String,
    @ColumnInfo var quantityInBottle: Int?,
    @Embedded var prescription: Prescription,
    @ColumnInfo var form : String,
//    @Embedded var measurement: Measurement?,

    @ColumnInfo @Contextual val expirationDate: String?,
    @ColumnInfo @Contextual var startDate: String?,
    @ColumnInfo val cabinetID: String,
    @Embedded var reminderID: String?,
) {
    constructor(
        consumableID: String,
        quantityInBottle: Int?,
        prescription: Prescription,
        form : String,
        expirationDate: String?,
        startDate: String?,
        cabinetID: String,
        reminderID: String?
    ) : this(
        0,
        consumableID,
        quantityInBottle,
        prescription,
        form,
        expirationDate,
        startDate,
        cabinetID,
        reminderID,
    )
}
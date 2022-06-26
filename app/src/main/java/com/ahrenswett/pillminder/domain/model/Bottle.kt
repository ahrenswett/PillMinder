package com.ahrenswett.pillminder.domain.model

import androidx.room.*
import com.ahrenswett.pillminder.domain.util.Type
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Entity(tableName = "bottles")
@Serializable
data class Bottle(
@PrimaryKey(autoGenerate = true) val bottleid: Int,
    @ColumnInfo var consumableID: String,
    @ColumnInfo var quantityInBottle: Int?,
//    @Embedded var prescription : Prescription?,
//    @Embedded var measurement: Measurement?,
//    @Embedded var reminder: Reminder?,
    @ColumnInfo @Contextual val expirationDate: String?,
    @ColumnInfo @Contextual var startDate: String?,
    @ColumnInfo val cabinetID: String
) {
    constructor(
        consumableID: String,
        quantityInBottle: Int?,
        expirationDate: String?,
        startDate: String?,
        cabinetID: String
    ) : this(
        0,
        consumableID,
        quantityInBottle,
        expirationDate,
        startDate,
        cabinetID
    )
}
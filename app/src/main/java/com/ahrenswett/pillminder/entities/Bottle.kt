package com.ahrenswett.pillminder.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Bottle(
    @PrimaryKey (autoGenerate = true)
    val consumableID: String,
    @Embedded var prescription : Prescription?,
    @Embedded var measurement: Measurement?,
    @Embedded var reminder: Reminder?,
    var quantityInBottle: Int?,
    val expirationDate : Date?,
    var startDate : Date?
)


enum class Measurement {
    MILLIGRAMS,
    SCOOP,
    GRAMS,
    OZ,
    TSP,
    TBS,
}
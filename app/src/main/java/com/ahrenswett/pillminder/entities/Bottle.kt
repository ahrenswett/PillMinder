package com.ahrenswett.pillminder.entities

import androidx.room.Entity
import java.util.*

@Entity
data class Bottle(
    val consumable: Consumable,
    val prescription : Prescription?,
    var measurement: Measurement?,
    var reminder: Reminder?,
    var quantityInBottle: Int? = null,
    val expirationDate : Date? = null,
    var startDate : Date?
)


enum class Measurement {
    MILLIGRAMS,
    FORM,
    SCOOP,
    WEIGHT,
    TSP,
    TBS,
}

enum class Type {
    MEDICATION,
    SUPPLEMENT
}

enum class Form {
    TABLET,
    CAPSULE,
    POWDER
}
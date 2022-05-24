package com.ahrenswett.pillminder.classes

import java.util.*

class Bottle( val consumable: Consumable,
              val prescription : Prescription?,
              var reminder: Reminder,
              var quantityInBottle: Int,
              val expirationDate : Date?,
              var startDate : Date)

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
package com.ahrenswett.pillminder.classes

import java.util.*

class Bottle( val consumable: Consumable,
              val prescription : Prescription?,
              var quantityInBottle: Int,
              val expirationDate : Date?,
              var startDate : Date)

class Prescription ( val volumeToTake: Int,

                     var prescribingDoc :String?)

class Consumable ( val name: String,
                   val type: Type,
                   val VolumePerUnit: Float,
                   val form: Form)


class Dose (var amount : Int, var mesurement: Mesurement) {}

enum class Mesurement {
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
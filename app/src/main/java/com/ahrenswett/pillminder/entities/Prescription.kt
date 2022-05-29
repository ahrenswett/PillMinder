package com.ahrenswett.pillminder.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Prescription (
    @PrimaryKey(autoGenerate = true)
    @Embedded val dose :Dose,
    val timesToTakePerDay: Int,
    var prescribingDoc :String?
    )
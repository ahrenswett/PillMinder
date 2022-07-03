package com.ahrenswett.pillminder.domain.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Prescription (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo val id: Int,
    @ColumnInfo  val dose : Int,
    @ColumnInfo val timesToTakePerDay: Int,
    @ColumnInfo var prescribingDoc :String?,
    @ColumnInfo var phoneNumber :String?
    )
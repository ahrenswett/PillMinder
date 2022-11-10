package com.ahrenswett.pillminder.domain.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Prescription (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo  val dose : Int,
    @ColumnInfo val timesToTakePerDay: Int,
    @ColumnInfo var prescribingDoc :String?,
    @ColumnInfo var phoneNumber :String?
    )
package com.ahrenswett.pillminder.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["firstName", "lastName"])
data class User(
    @ColumnInfo (name = "first_name") val firstname: String?,
    @ColumnInfo (name = "last_name") val lastname: String?
)


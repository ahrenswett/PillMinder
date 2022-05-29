package com.ahrenswett.pillminder.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "username") val username : String?,
    @ColumnInfo (name = "first_name") val firstname: String?,
    @ColumnInfo (name = "last_name") val lastname: String?
)


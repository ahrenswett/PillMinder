package com.ahrenswett.pillminder.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Consumable (
    @PrimaryKey val name: String,
    @ColumnInfo val type: Type,
    @ColumnInfo val VolumePerUnit: Float,
    @ColumnInfo val form: Form
    )
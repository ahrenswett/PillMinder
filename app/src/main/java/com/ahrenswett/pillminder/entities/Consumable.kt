package com.ahrenswett.pillminder.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity (primaryKeys = ["name", "VolumePerUnit"])
data class Consumable (
    @ColumnInfo val name: String,
    @ColumnInfo val VolumePerUnit: Float,
    @ColumnInfo val form: Form,
    @ColumnInfo val supplementOrMedication: Type
    )

enum class Type {
    MEDICATION,
    SUPPLEMENT
}

enum class Form {
    TABLET,
    CAPSULE,
    POWDER
}
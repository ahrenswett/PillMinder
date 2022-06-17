package com.ahrenswett.pillminder.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import org.jetbrains.annotations.NotNull

@Entity (tableName = "consumables", primaryKeys = ["name", "volumePerUnit"])
data class Consumable (
    @ColumnInfo @NotNull val name: String,
    @ColumnInfo @NotNull val volumePerUnit: Float,
//    @ColumnInfo val form: Form,
//    @ColumnInfo val supplementOrMedication: Type
    )


//enum class Form {
//    TABLET,
//    CAPSULE,
//    POWDER
//}
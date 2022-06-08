package com.ahrenswett.pillminder.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity (tableName = "consumables", primaryKeys = ["name", "volumePerUnit"])
data class Consumable (
    @ColumnInfo val name: String,
    @ColumnInfo val volumePerUnit: Float,
//    @ColumnInfo val form: Form,
//    @ColumnInfo val supplementOrMedication: Type
    )

//enum class Type {
//    MEDICATION,
//    SUPPLEMENT
//}
//
//enum class Form {
//    TABLET,
//    CAPSULE,
//    POWDER
//}
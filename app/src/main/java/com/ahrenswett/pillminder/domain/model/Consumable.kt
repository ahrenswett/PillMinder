package com.ahrenswett.pillminder.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.jetbrains.annotations.NotNull

@Entity (tableName = "consumables", primaryKeys = ["name", "measurementPerUnit"])
//@Serializable
data class Consumable (
    @ColumnInfo @NotNull val name: String,
    @ColumnInfo @NotNull val measurementPerUnit: Float,
    @ColumnInfo @Contextual val form: String,
    @ColumnInfo @NotNull val medication: Boolean,
    )
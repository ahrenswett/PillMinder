package com.ahrenswett.pillminder.domain.model

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "cabinets")
data class Cabinet(
    @NonNull
    @PrimaryKey @ColumnInfo(name = "cabinet") var name: String
)
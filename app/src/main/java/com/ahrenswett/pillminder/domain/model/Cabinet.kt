package com.ahrenswett.pillminder.domain.model

import androidx.annotation.NonNull
import androidx.room.*
import kotlinx.serialization.Serializable

@Entity(tableName = "cabinets")
data class Cabinet(
    @NonNull
    @PrimaryKey @ColumnInfo(name = "cabinet") var name: String,

//    @Serializable var bottleList: List<Bottle>

//    val owner: User
//    var userList: List<User>
)

package com.ahrenswett.pillminder.domain.model

import androidx.annotation.NonNull
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

@Entity(tableName = "cabinets")
//@Serializable
data class Cabinet(
    @NonNull
    @PrimaryKey @ColumnInfo(name = "cabinet") var name: String,

//var bottleList: Flow<List<Bottle>>

//    val owner: User
//    var userList: List<User>
)



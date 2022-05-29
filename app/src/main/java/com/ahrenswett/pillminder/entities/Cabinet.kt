package com.ahrenswett.pillminder.entities

import androidx.annotation.NonNull
import androidx.room.*

@Entity
data class Cabinet(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "cabinet") var name: String
){
    var bottleList : ArrayList<Bottle> = ArrayList()

    fun addBottle(bottle: Bottle){
        bottleList.add(bottle)
    }

}
package com.ahrenswett.pillminder.data.daos

import androidx.room.*
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import kotlinx.coroutines.flow.Flow

@Dao
interface BottleDAO {
    @Query("SELECT * FROM bottles WHERE cabinetID = :cabinet")
    fun getBottlesInCabinet(cabinet : String): Flow<List<Bottle>>

    @Query("SELECT * FROM bottles")
    fun getBottles() : Flow<List<Bottle>>

//    @Insert(onConflict = OnConflictStrategy.ABORT)
//    suspend fun addBottleToCabinet(cabinet: String)

    @Delete
    suspend fun deleteBottle(bottle: Bottle)
}
package com.ahrenswett.pillminder.data.daos

import androidx.room.*
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import kotlinx.coroutines.flow.Flow


@Dao
interface CabinetDAO {

    @Query("SELECT * FROM cabinets")
    fun getCabinets(): Flow<List<Cabinet>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addNewCabinet(cabinet: Cabinet)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addBottle(bottle: Bottle, cabinet: Cabinet)

    @Query("Select * FROM cabinets WHERE cabinet= :cabinetName")
    suspend fun getCabinetById(cabinetName: String):Cabinet?

    @Delete
    suspend fun deleteCabinet(cabinet: Cabinet)

}
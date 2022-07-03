package com.ahrenswett.pillminder.data.daos

import androidx.room.*
import com.ahrenswett.pillminder.domain.model.Consumable
import kotlinx.coroutines.flow.Flow
@Dao
interface ConsumableDAO {
    @Query("SELECT * FROM consumables")
    fun listConsumables(): Flow<List<Consumable>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addNewConsumable(consumable: Consumable)

    @Query("Select * FROM consumables WHERE name AND measurementPerUnit =:consumable")
    suspend fun getConsumableById(consumable: String): Consumable

    @Delete
    suspend fun deleteConsumable(consumable: Consumable)
}
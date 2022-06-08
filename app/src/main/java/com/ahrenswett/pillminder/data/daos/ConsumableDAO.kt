package com.ahrenswett.pillminder.data.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahrenswett.pillminder.domain.model.Consumable
import kotlinx.coroutines.flow.Flow

interface ConsumableDAO {
    @Query("SELECT * FROM consumables")
    fun listConsumables(): Flow<List<Consumable>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addNewConsumable(consumable: Consumable)

    @Query("Select * FROM consumables WHERE name&volumePerUnit =:consumable")
    suspend fun getConsumableById(consumable: Consumable): Consumable?

    @Delete
    suspend fun deleteConsumable(consumable: Consumable)
}
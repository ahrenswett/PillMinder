package com.ahrenswett.pillminder.domain.repos
import com.ahrenswett.pillminder.domain.model.Consumable
import kotlinx.coroutines.flow.Flow

interface ConsumableRepo{
    fun listConsumables(): Flow<List<Consumable>>

    suspend fun addNewConsumable(consumable: Consumable)

    suspend fun getConsumableById(consumable: Consumable): Consumable?

    suspend fun deleteConsumable(consumable: Consumable)
}
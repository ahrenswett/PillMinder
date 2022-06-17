package com.ahrenswett.pillminder.domain.repos

import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import kotlinx.coroutines.flow.Flow

interface BottleRepo {
    fun getBottlesInCabinet(cabinetName: String): Flow<List<Bottle>>

    fun getBottles(): Flow<List<Bottle>>

    suspend fun getBottleById(bottleId: Int): Bottle?

    suspend fun addBottleToCabinet(bottle: Bottle, cabinet: Cabinet)

    suspend fun deleteBottle(bottle: Bottle)
}
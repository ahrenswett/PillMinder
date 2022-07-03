package com.ahrenswett.pillminder.data.repositories

import com.ahrenswett.pillminder.data.daos.ConsumableDAO
import com.ahrenswett.pillminder.domain.model.Consumable
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import kotlinx.coroutines.flow.Flow

class ConsumableRepoImpl (private val dao: ConsumableDAO): ConsumableRepo {
    override fun listConsumables(): Flow<List<Consumable>> {
        return dao.listConsumables()
    }

    override suspend fun addNewConsumable(consumable: Consumable) {
        dao.addNewConsumable(consumable)
    }

    override suspend fun getConsumableById(consumable: Consumable): Consumable {
        return dao.getConsumableById(consumable.name+consumable.measurementPerUnit)
    }

    override suspend fun deleteConsumable(consumable: Consumable) {
        dao.deleteConsumable(consumable)
    }
}
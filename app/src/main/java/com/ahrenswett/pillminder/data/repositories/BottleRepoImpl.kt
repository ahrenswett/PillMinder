package com.ahrenswett.pillminder.data.repositories

import com.ahrenswett.pillminder.data.daos.BottleDAO
import com.ahrenswett.pillminder.data.daos.CabinetDAO
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import kotlinx.coroutines.flow.Flow

class BottleRepoImpl(private val bottleDAO: BottleDAO, private val cabinetDAO: CabinetDAO) : BottleRepo {
    override fun getBottlesInCabinet(cabinetName : String): Flow<List<Bottle>> {
        return bottleDAO.getBottlesInCabinet(cabinetName)
    }

    override fun getBottles(): Flow<List<Bottle>>{
        return bottleDAO.getBottles()
    }

    override suspend fun getBottleById(bottleId: Int): Bottle? {
        TODO("Not yet implemented")
    }

    override suspend fun addBottle(bottle: Bottle) {
        bottleDAO.addBottle(bottle)
    }

    override suspend fun deleteBottle(bottle: Bottle) {
        TODO("Not yet implemented")
    }
}
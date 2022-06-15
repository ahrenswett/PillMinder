package com.ahrenswett.pillminder.data.repositories

import androidx.compose.material.BackdropValue
import com.ahrenswett.pillminder.data.daos.BottleDAO
import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import kotlinx.coroutines.flow.Flow

class BottleRepoImpl(private val dao: BottleDAO) : BottleRepo {
    override fun getBottlesInCabinet(cabinetName : String): Flow<List<Bottle>> {
        return dao.getBottlesInCabinet(cabinetName)
    }

    override fun getBottles(): Flow<List<Bottle>>{
        return dao.getBottles()
    }

    override suspend fun addBottleToCabinet(cabinetName : String) {
        dao.addBottleToCabinet(cabinetName)
    }

    override suspend fun deleteBottle(bottle: Bottle) {
        TODO("Not yet implemented")
    }
}
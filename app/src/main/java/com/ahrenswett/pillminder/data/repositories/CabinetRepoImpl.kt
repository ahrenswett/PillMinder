package com.ahrenswett.pillminder.data.repositories

import com.ahrenswett.pillminder.data.daos.CabinetDAO
import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import kotlinx.coroutines.flow.Flow

class CabinetRepoImpl (private val dao: CabinetDAO):CabinetRepo {
    override fun getCabinets(): Flow<List<Cabinet>> {
        return dao.getCabinets()
    }

    override suspend fun getCabinetById(cabinetName: String): Cabinet? {
        return dao.getCabinetById(cabinetName)
    }

    override suspend fun insertCabinet(cabinet: Cabinet) {
        dao.addNewCabinet(cabinet)
    }

    override suspend fun deleteCabinet(cabinet: Cabinet) {
        dao.deleteCabinet(cabinet)
    }

}
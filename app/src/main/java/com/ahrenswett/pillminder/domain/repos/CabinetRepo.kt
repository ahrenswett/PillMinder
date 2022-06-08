package com.ahrenswett.pillminder.domain.repos

import androidx.annotation.WorkerThread
import com.ahrenswett.pillminder.data.daos.CabinetDAO
import com.ahrenswett.pillminder.domain.model.Cabinet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

interface CabinetRepo{
    fun getCabinets(): Flow<List<Cabinet>>

    suspend fun getCabinetById(cabinetName: String): Cabinet?

    suspend fun insertCabinet(cabinet: Cabinet)

    suspend fun deleteCabinet(cabinet: Cabinet)
}
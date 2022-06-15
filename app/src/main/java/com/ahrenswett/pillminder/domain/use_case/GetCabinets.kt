package com.ahrenswett.pillminder.domain.use_case

import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import kotlinx.coroutines.flow.Flow

class GetCabinets (private val repo: CabinetRepo){
    //allows to call class as function
    operator fun invoke(): Flow<List<Cabinet>>{
        return repo.getCabinets()
    }
}
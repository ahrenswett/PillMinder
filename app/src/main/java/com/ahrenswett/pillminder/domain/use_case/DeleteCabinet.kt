package com.ahrenswett.pillminder.domain.use_case

import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.domain.repos.CabinetRepo

class DeleteCabinet (private val repo: CabinetRepo) {

    suspend operator fun invoke(cabinet: Cabinet){
        repo.deleteCabinet(cabinet)
    }
}
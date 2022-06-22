package com.ahrenswett.pillminder.ui.cabinet_view

import androidx.lifecycle.ViewModel
import com.ahrenswett.pillminder.domain.repos.BottleRepo
import com.ahrenswett.pillminder.domain.repos.CabinetRepo
import com.ahrenswett.pillminder.domain.repos.ConsumableRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CabinetViewViewModel @Inject constructor(
    private val cabinetRepo: CabinetRepo,
    private val bottleRepo: BottleRepo,
    private val consumableRepo: ConsumableRepo
):ViewModel(){


}
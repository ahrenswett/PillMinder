package com.ahrenswett.pillminder.ui.cabinet_view

import com.ahrenswett.pillminder.domain.model.Bottle
import com.ahrenswett.pillminder.domain.model.Cabinet

sealed class CabinetViewEvent {
    // Add a Bottle
    data class AddBottle(val cabinetID: String, val tabIndex: Int): CabinetViewEvent()
    // Open Menu
    object OpenMenu : CabinetViewEvent()
    // Expand Bottle Description
}
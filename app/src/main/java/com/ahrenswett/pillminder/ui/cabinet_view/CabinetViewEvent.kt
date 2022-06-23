package com.ahrenswett.pillminder.ui.cabinet_view

import com.ahrenswett.pillminder.domain.model.Bottle

sealed class CabinetViewEvent {
    // Add a Bottle
    data class AddBottle (val bottle: Bottle): CabinetViewEvent()
    // Open Menu
    object OpenMenu : CabinetViewEvent()
    // Expand Bottle Description
}
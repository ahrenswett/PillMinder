package com.ahrenswett.pillminder.ui.cabinet_list

import com.ahrenswett.pillminder.domain.model.Cabinet
import com.ahrenswett.pillminder.ui.cabinet_view.CabinetViewEvent

sealed class CabinetListEvent{
    // Add cabinet
    object AddNewCabinet : CabinetListEvent()
    // viewCabinet
    data class ViewCabinet(val cabinet: Cabinet): CabinetListEvent()

    //Add new bottle to cabinet in list
    data class AddBottle(val cabinetID: String, val tabIndex: Int): CabinetListEvent()

    // deleteCabinet / undo delete ??
}

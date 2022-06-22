package com.ahrenswett.pillminder.ui.cabinet_list

import com.ahrenswett.pillminder.domain.model.Cabinet

sealed class CabinetListEvent{
    // Add cabinet to user
    // Add cabinet
    object AddNewCabinet : CabinetListEvent()
    // add Bottle To Cabinet
    data class AddBottleToCabinet(val cabinet: Cabinet) : CabinetListEvent()
    // viewCabinet
    data class ViewCabinet(val cabinet: Cabinet): CabinetListEvent()
    // deleteCabinet / undo delete ??
    //
}

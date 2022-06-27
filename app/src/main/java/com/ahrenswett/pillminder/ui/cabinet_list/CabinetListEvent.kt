package com.ahrenswett.pillminder.ui.cabinet_list

import com.ahrenswett.pillminder.domain.model.Cabinet

sealed class CabinetListEvent{
    // Add cabinet
    object AddNewCabinet : CabinetListEvent()
    // viewCabinet
    data class ViewCabinet(val cabinet: Cabinet): CabinetListEvent()
    // deleteCabinet / undo delete ??
}

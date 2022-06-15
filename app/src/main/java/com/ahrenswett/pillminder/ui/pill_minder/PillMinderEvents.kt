package com.ahrenswett.pillminder.ui.pill_minder

import com.ahrenswett.pillminder.domain.model.Cabinet

sealed class PillMinderEvents{
    // addCabinet

    // addBottle
    data class AddBottleToCabinet(val cabinet: Cabinet) : PillMinderEvents()
    // viewCabinet
    data class ViewCabinet(val cabinet: Cabinet): PillMinderEvents()
    // deleteCabinet / undo delete ??
    //
}

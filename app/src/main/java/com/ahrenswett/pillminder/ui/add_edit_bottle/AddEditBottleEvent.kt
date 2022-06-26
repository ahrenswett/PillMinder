package com.ahrenswett.pillminder.ui.add_edit_bottle

import com.ahrenswett.pillminder.domain.util.Type


sealed class AddEditBottleEvent{
    data class OnNameChange(val consumableID : String) : AddEditBottleEvent()
    data class OnQuantityChange(val quantity : Int) :AddEditBottleEvent()
    data class OnExpirationDateChange(val expirationDate : String) : AddEditBottleEvent()
    data class OnStartDateChange(val startDate: String) : AddEditBottleEvent()

    /*TODO:
     * Add reminder picker events
     * Add measurement choices
     * Add prescription gathering information
     * calendar picker for Expiration Date
     * calendar picker for Start date
     */

    object OnSubmit : AddEditBottleEvent()
}
